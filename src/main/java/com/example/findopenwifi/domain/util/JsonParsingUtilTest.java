package com.example.findopenwifi.domain.util;

import com.example.findopenwifi.domain.service.OpenWifiServiceImpl;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class JsonParsingUtilTest {

    JsonParsingUtil jsonParsingUtil = JsonParsingUtil.INSTANCE;
    private static String testJson = "{\n" +
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
            "                \"WORK_DTTM\": \"2023-03-28 10:58:17.0\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";

    @Test
    void 문자열로_부터_JsonObject_가져오기() {
        JsonObject tbPublicWifiInfo = jsonParsingUtil.getJsonObject(testJson, "TbPublicWifiInfo");

        assertThat(tbPublicWifiInfo).isInstanceOf(JsonObject.class);
    }

    @Test
    void list_total_count_가져오기() {
        JsonObject tbPublicWifiInfo = jsonParsingUtil.getJsonObject(testJson, "TbPublicWifiInfo");

        int listTotalCount = jsonParsingUtil.getInt(tbPublicWifiInfo, "list_total_count");
        assertThat(listTotalCount).isEqualTo(23406);
    }

    @Test
    void result_code_and_message_가져오기() {
        JsonObject tbPublicWifiInfo = jsonParsingUtil.getJsonObject(testJson, "TbPublicWifiInfo");
        JsonObject result = jsonParsingUtil.getJsonObject(tbPublicWifiInfo, "RESULT");
        String code = jsonParsingUtil.getString(result, "CODE");
        String message = jsonParsingUtil.getString(result, "MESSAGE");

        assertThat(code).isEqualTo("INFO-000");
        assertThat(message).isEqualTo("정상 처리되었습니다");
    }
}