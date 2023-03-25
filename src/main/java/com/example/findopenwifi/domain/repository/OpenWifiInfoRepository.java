package com.example.findopenwifi.domain.repository;

import com.example.findopenwifi.domain.model.OpenWifiInfo;

import java.util.List;

public interface OpenWifiInfoRepository {

    void save(OpenWifiInfo openWifiInfo);

    List<OpenWifiInfo> findAll();
}
