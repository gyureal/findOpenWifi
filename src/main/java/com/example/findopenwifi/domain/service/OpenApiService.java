package com.example.findopenwifi.domain.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public enum OpenApiService {

    INSTANCE;

    public int getApiCount() {
        String result = requestOpenApi(1, 1);
        System.out.println(result);

        return 0;
    }

    private String requestOpenApi(int fromNumber, int toNumber) {
        StringBuffer result = new StringBuffer();
        String strResult = "";
        try {
            // URL 설정
            StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088/");

            // search 변수는 인코딩이 필요하다고 했으므로 그 부분만 인코딩
            urlBuilder.append("5245626172696f7034395975634f72");  // key
            urlBuilder.append("/xml");
            urlBuilder.append("/TbPublicWifiInfo");
            urlBuilder.append("/" + fromNumber);
            urlBuilder.append("/" + toNumber);

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            // Request 형식 설정
            conn.setRequestMethod("GET");
            //conn.setRequestProperty("Content-Type", "application/json");

            // 응답 데이터 받아오기
            BufferedReader rd;
            if(conn.getResponseCode() >= 200 & conn.getResponseCode() <= 300) {
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
