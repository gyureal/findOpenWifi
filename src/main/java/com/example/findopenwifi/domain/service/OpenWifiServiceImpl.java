package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import com.example.findopenwifi.domain.repository.OpenWifiInfoRepository;
import com.example.findopenwifi.web.dto.OpenWifiInfoDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OpenWifiServiceImpl implements OpenWifiService {

    private static final int FILTERED_COUNT = 20;

    private final OpenWifiInfoRepository openWifiInfoRepository;

    @Override
    public void saveOpenApiRawData(OpenWifiInfo openWifiInfo) {

    }

    @Override
    public List<OpenWifiInfo> getWifiNearBy(double x, double y) {

        List<OpenWifiInfo> allInfos = openWifiInfoRepository.findAll();

        List<OpenWifiInfo> filteredList = filterNearData(allInfos, FILTERED_COUNT);


        return null;
    }

    private List<OpenWifiInfo> filterNearData(List<OpenWifiInfo> allInfos, int filteredCount) {


        return null;
    }


}
