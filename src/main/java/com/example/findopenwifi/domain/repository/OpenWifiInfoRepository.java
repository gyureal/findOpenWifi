package com.example.findopenwifi.domain.repository;

import com.example.findopenwifi.domain.model.OpenWifiInfo;

import java.util.List;

public interface OpenWifiInfoRepository {

    String save(OpenWifiInfo openWifiInfo);

    List<OpenWifiInfo> findAll();

    OpenWifiInfo findByMgrNo(String mgrNo);

    void deleteAll();
}
