package com.example.findopenwifi.persistence.jdbc.repositoryImpl;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;

@RequiredArgsConstructor
class OpenWifiInfoRepositoryImplTest {

    //private final OpenWifiInfoRepository openWifiInfoRepository;
    @Test
    void 공공API_RAW_DATA_INSERT() {

        OpenWifiInfo openWifiInfo = OpenWifiInfo.builder()
                .mgrNo("test001")
                .wrdofc("구로구")
                .mainNm("버스정류소")
                .lat(126.88979)
                .lnt(37.499557)
                .workDttm("2023-03-25 10:58:17.0")
                .build();


        OpenWifiInfoRepositoryImpl openWifiInfoRepository = new OpenWifiInfoRepositoryImpl();
        openWifiInfoRepository.save(openWifiInfo);
    }

    @Test
    void 공공API테이블_전체_조회() {

        OpenWifiInfoRepositoryImpl openWifiInfoRepository = new OpenWifiInfoRepositoryImpl();
        List<OpenWifiInfo> openWifiInfoList = openWifiInfoRepository.findAll();

        System.out.println(openWifiInfoList);

    }


}