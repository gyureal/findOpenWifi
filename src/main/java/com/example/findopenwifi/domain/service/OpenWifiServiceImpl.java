package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import com.example.findopenwifi.domain.repository.OpenWifiInfoRepository;
import com.example.findopenwifi.persistence.jdbc.Dao.OpenWifiInfoDAO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public enum OpenWifiServiceImpl implements OpenWifiService {

    INSTANCE;   //  enum 객체 수

    private static final int FILTERED_COUNT = 20;
    private final OpenWifiInfoRepository openWifiInfoRepository;

    OpenWifiServiceImpl() {  // enum 은 싱글톤, public 생성자 사용 못함 -> new 불가
        openWifiInfoRepository = new OpenWifiInfoDAO();
    }

    @Override
    public void saveOpenApiRawData(List<OpenWifiInfo> openWifiInfo) {
        openWifiInfo.stream().forEach(openWifiInfoRepository::save);
    }

    @Override
    public List<OpenWifiInfo> getWifiNearBy(double x, double y) {

        List<OpenWifiInfo> allInfos = openWifiInfoRepository.findAll();

        List<OpenWifiInfo> filteredList = filterNearData(allInfos, FILTERED_COUNT);


        return filteredList;
    }

    private List<OpenWifiInfo> filterNearData(List<OpenWifiInfo> allInfos, int filteredCount) {


        return null;
    }

}
