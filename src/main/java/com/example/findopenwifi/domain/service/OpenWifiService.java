package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.dto.OpenWifiInfoDTO;
import com.example.findopenwifi.domain.model.OpenWifiInfo;


import java.util.List;

public interface OpenWifiService {

    void saveOpenApiRawData(List<OpenWifiInfo> openWifiInfo);

    List<OpenWifiInfoDTO> getWifiNearBy(double x, double y);

    OpenWifiInfoDTO getWifiInfo(String mgrNo);
}
