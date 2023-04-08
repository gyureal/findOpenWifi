package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import com.example.findopenwifi.domain.repository.OpenWifiInfoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class OpenWifiServiceImplTest {

    OpenWifiService openWifiService = OpenWifiServiceImpl.INSTANCE;

    @Test
    @DisplayName("입력 받은 좌표값 기준 가까이 있는 20개데이터 리턴")
    void getWifiNearBy_test(@Mock OpenWifiInfoRepository openWifiInfoRepository) {
        // given
        double x = 1.0;
        double y = 1.0;

        int length = 21;
        given(openWifiInfoRepository.findAll()).willReturn(generateAllInfoData(length, x, y));

        // when
        List<OpenWifiInfo> wifiNearBy = openWifiService.getWifiNearBy(x, y);

        // then
        assertThat(wifiNearBy.size()).isEqualTo(20);
        assertThat(wifiNearBy.get(wifiNearBy.size())).isEqualTo("mgr_19");
    }

    List<OpenWifiInfo> generateAllInfoData(int length, double x, double y) {
        List<OpenWifiInfo> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            OpenWifiInfo data = OpenWifiInfo.builder()
                    .mgrNo("mgr_" + i)
                    .lnt(x + i)
                    .lat(y + i)
                    .build();

            list.add(data);
        }
        return list;
    }

}