package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import com.example.findopenwifi.domain.service.OpenApiService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OpenApiServiceTest {

    private static final OpenApiService openApiService = OpenApiService.INSTANCE;

    private static final String jsonData = "{\n" +
            "    \"TbPublicWifiInfo\": {\n" +
            "        \"list_total_count\": 23406,\n" +
            "        \"RESULT\": {\n" +
            "            \"CODE\": \"INFO-000\",\n" +
            "            \"MESSAGE\": \"정상 처리되었습니다\"\n" +
            "        },\n" +
            "        \"row\": [\n" +
            "            {\n" +
            "                \"X_SWIFI_MGR_NO\": \"--GR050009-1\",\n" +
            "                \"X_SWIFI_WRDOFC\": \"구로구\",\n" +
            "                \"X_SWIFI_MAIN_NM\": \"생활지역\",\n" +
            "                \"X_SWIFI_ADRES1\": \"구로동 741-27\",\n" +
            "                \"X_SWIFI_ADRES2\": \"서울구로지역자활센터\",\n" +
            "                \"X_SWIFI_INSTL_FLOOR\": \"\",\n" +
            "                \"X_SWIFI_INSTL_TY\": \"1. 주요거리\",\n" +
            "                \"X_SWIFI_INSTL_MBY\": \"교체예정\",\n" +
            "                \"X_SWIFI_SVC_SE\": \"공공WiFi\",\n" +
            "                \"X_SWIFI_CMCWR\": \"자가망_U무선망\",\n" +
            "                \"X_SWIFI_CNSTC_YEAR\": \"2016\",\n" +
            "                \"X_SWIFI_INOUT_DOOR\": \"실외\",\n" +
            "                \"X_SWIFI_REMARS3\": \"\",\n" +
            "                \"LAT\": \"126.88673\",\n" +
            "                \"LNT\": \"37.489075\",\n" +
            "                \"WORK_DTTM\": \"2023-03-29 10:58:17.0\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"X_SWIFI_MGR_NO\": \"--GR060001\",\n" +
            "                \"X_SWIFI_WRDOFC\": \"구로구\",\n" +
            "                \"X_SWIFI_MAIN_NM\": \"버스정류소\",\n" +
            "                \"X_SWIFI_ADRES1\": \"구로5동 102\",\n" +
            "                \"X_SWIFI_ADRES2\": \"CCTV 706\",\n" +
            "                \"X_SWIFI_INSTL_FLOOR\": \"\",\n" +
            "                \"X_SWIFI_INSTL_TY\": \"5-2. 버스정류소(시비)\",\n" +
            "                \"X_SWIFI_INSTL_MBY\": \"교체예정\",\n" +
            "                \"X_SWIFI_SVC_SE\": \"공공WiFi\",\n" +
            "                \"X_SWIFI_CMCWR\": \"자가망_U무선망\",\n" +
            "                \"X_SWIFI_CNSTC_YEAR\": \"2016\",\n" +
            "                \"X_SWIFI_INOUT_DOOR\": \"실외\",\n" +
            "                \"X_SWIFI_REMARS3\": \"\",\n" +
            "                \"LAT\": \"126.88955\",\n" +
            "                \"LNT\": \"37.49663\",\n" +
            "                \"WORK_DTTM\": \"2023-03-29 10:58:17.0\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";

    @Test
    void extractOpenWifiInfo_테스트() {
        String firstMgrNo = "--GR050009-1";
        String secondMgrNo = "--GR060001";

        List<OpenWifiInfo> openWifiInfos = openApiService.extractOpenWifiInfo(jsonData);
        OpenWifiInfo firstInfo = openWifiInfos.get(0);
        OpenWifiInfo secondInfo = openWifiInfos.get(1);

        assertThat(openWifiInfos.size()).isEqualTo(2);
        assertThat(firstInfo).isInstanceOf(OpenWifiInfo.class);
        assertThat(firstInfo.getMgrNo()).isEqualTo(firstMgrNo);
        assertThat(secondInfo.getMgrNo()).isEqualTo(secondMgrNo);
    }


}