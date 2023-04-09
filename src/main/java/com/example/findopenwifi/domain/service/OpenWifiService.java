package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import com.example.findopenwifi.web.dto.OpenWifiInfoDTO;

import java.util.List;

public interface OpenWifiService {

    public void saveOpenApiRawData(List<OpenWifiInfo> openWifiInfo);

    public List<OpenWifiInfoDTO> getWifiNearBy(double x, double y);
}
