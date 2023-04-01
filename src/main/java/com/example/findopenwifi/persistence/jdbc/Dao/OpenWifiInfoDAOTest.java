package com.example.findopenwifi.persistence.jdbc.Dao;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


import java.util.List;

class OpenWifiInfoDAOTest {

    private OpenWifiInfoDAO openWifiInfoDAO;

    @BeforeEach
    void ready() {
        openWifiInfoDAO = new OpenWifiInfoDAO();
    }

    //private final OpenWifiInfoRepository openWifiInfoRepository;
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

        openWifiInfoDAO.save(openWifiInfo);

        OpenWifiInfo findInfo = openWifiInfoDAO.findByMgrNo(mgrNo);
        assertThat(findInfo.getMgrNo()).isEqualTo(mgrNo);
    }

    @Test
    void 공공API테이블_전체_조회() {

        List<OpenWifiInfo> openWifiInfoList = openWifiInfoDAO.findAll();

        System.out.println(openWifiInfoList);
    }

    @Test
    void 데이터_삭제() {
        openWifiInfoDAO.deleteAll();

        List<OpenWifiInfo> all = openWifiInfoDAO.findAll();
        assertThat(all.size()).isEqualTo(0);
    }
}