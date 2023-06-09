package com.example.findopenwifi.domain.repository;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import com.example.findopenwifi.domain.repository.OpenWifiInfoRepository;
import com.example.findopenwifi.persistence.jdbc.Dao.OpenWifiInfoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


import java.util.List;

class OpenWifiInfoRepositoryTest {

    private OpenWifiInfoRepository openWifiInfoRepository = new OpenWifiInfoDAO();

    @Test
    void 공공API_RAW_DATA_INSERT() {

        String mgrNo = "test001";
        String wrdofc = "구로구";
        String mainNm = "버스정류소";
        double lat = 126.88979;
        double lnt = 37.499557;
        String workDttm = "2023-03-25 10:58:17.0";


        OpenWifiInfo openWifiInfo = OpenWifiInfo.builder()
                .mgrNo(mgrNo)
                .wrdofc(wrdofc)
                .mainNm(mainNm)
                .lat(lat)
                .lnt(lnt)
                .workDttm(workDttm)
                .build();

        openWifiInfoRepository.save(openWifiInfo);

        OpenWifiInfo findInfo = openWifiInfoRepository.findByMgrNo(mgrNo);
        assertThat(findInfo.getMgrNo()).isEqualTo(mgrNo);
    }

    @Test
    void 공공API테이블_전체_조회() {

        List<OpenWifiInfo> openWifiInfoList = openWifiInfoRepository.findAll();

        System.out.println(openWifiInfoList);
    }

    @Test
    void 데이터_삭제() {
        openWifiInfoRepository.deleteAll();

        List<OpenWifiInfo> all = openWifiInfoRepository.findAll();
        assertThat(all.size()).isEqualTo(0);
    }
}