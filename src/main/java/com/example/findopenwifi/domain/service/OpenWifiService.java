package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.model.OpenWifiInfo;

import java.util.List;

public interface OpenWifiService {

    public void saveOpenApiRawData(OpenWifiInfo openWifiInfo);

    public List<OpenWifiInfo> getWifiNearBy(double x, double y);
}
