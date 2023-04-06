package com.example.findopenwifi.domain.model;

import com.example.findopenwifi.domain.dto.RawWifiInfoObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenWifiInfoTest {

    @Test
    void create_test() {

        String mgrNo = "test11";
        double lat = 2.33;
        double lnt = 3.224;

        RawWifiInfoObject dto = new RawWifiInfoObject();
        dto.setX_SWIFI_MGR_NO(mgrNo);
        dto.setLAT(lat);
        dto.setLNT(lnt);

        OpenWifiInfo openWifiInfo = OpenWifiInfo.from(dto);

        assertNotNull(openWifiInfo);
        assertEquals(mgrNo, openWifiInfo.getMgrNo());
    }

}