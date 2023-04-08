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

    @Test
    void 거리계산() {
        // given
        String mgrNo = "test01";
        double lnt = 1;
        double lat = 1;
        double x = 2;
        double y = 2;

        OpenWifiInfo info = OpenWifiInfo.builder()
                .mgrNo(mgrNo)
                .lnt(lnt)
                .lat(lat)
                .build();

        // when
        double distance = info.calculateDistance(x, y);

        // then
        assertEquals(Math.sqrt(2) ,distance);

    }

}