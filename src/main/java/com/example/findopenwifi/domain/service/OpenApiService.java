package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import com.example.findopenwifi.domain.util.JsonParsingUtil;
import com.example.findopenwifi.persistence.jdbc.repositoryImpl.OpenWifiInfoDAO;
import com.example.findopenwifi.domain.dto.RawWifiInfoObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public enum OpenApiService {

    INSTANCE;

    private static final Gson gson = new Gson();
    private static final JsonParsingUtil jsonParsingUtil = JsonParsingUtil.INSTANCE;
    private static final OpenWifiInfoDAO openWifiInfoDao = new OpenWifiInfoDAO();

    public void getAllOpenWifiData() {

    }

    public void saveOpenWifiInfoFromTo(int fromNumber, int toNumber) {
        List<OpenWifiInfo> openWifiInfoList = getOpenWifiInfoFromTo(fromNumber, toNumber);

        for (OpenWifiInfo openWifiInfo : openWifiInfoList) {
            openWifiInfoDao.save(openWifiInfo);
        }
    }

    public List<OpenWifiInfo> getOpenWifiInfoFromTo(int fromNumber, int toNumber) {
        String rawOpenWifiData = getRawOpenWifiData(fromNumber, toNumber);
        return extractOpenWifiInfo(rawOpenWifiData);
    }

    public List<OpenWifiInfo> extractOpenWifiInfo(String rawOpenWifiData) {
        // RawWifiInfoObject 데이터 추출하기
        JsonObject tbPublicWifiInfo = jsonParsingUtil.getJsonObject(rawOpenWifiData, "TbPublicWifiInfo");
        JsonArray jsonArray = jsonParsingUtil.getJsonArray(tbPublicWifiInfo, "row");

        List<OpenWifiInfo> wifiInfoList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            RawWifiInfoObject raw = gson.fromJson(jsonArray.get(i), RawWifiInfoObject.class);

            OpenWifiInfo openWifiInfo = OpenWifiInfo.from(raw);
            wifiInfoList.add(openWifiInfo);
        }
        return wifiInfoList;
    }

    public String getRawOpenWifiData(int fromNumber, int toNumber) {
        StringBuffer result = new StringBuffer();
        String strResult = "";
        try {
            // URL 설정
            StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088/");

            urlBuilder.append("5245626172696f7034395975634f72");  // key
            urlBuilder.append("/json");
            urlBuilder.append("/TbPublicWifiInfo");
            urlBuilder.append("/" + fromNumber);
            urlBuilder.append("/" + toNumber);

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            // Request 형식 설정
            conn.setRequestMethod("GET");

            // 응답 데이터 받아오기
            BufferedReader rd;
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            String line;
            while((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            conn.disconnect();
            strResult = result.toString();
        } catch ( Exception e ){
            e.printStackTrace();
        }
        return strResult;
    }

}
