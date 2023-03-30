package com.example.findopenwifi.domain.util;

import com.example.findopenwifi.domain.service.OpenWifiServiceImpl;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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

    private static final String endJsonData = "{\n" +
            "    \"RESULT\": {\n" +
            "        \"CODE\": \"ERROR-336\",\n" +
            "        \"MESSAGE\": \"데이터요청은 한번에 최대 1,000건을 넘을 수 없습니다.\\n요청종료위치에서 요청시작위치를 뺀 값이 1000을 넘지 않도록 수정하세요.\"\n" +
            "    }\n" +
            "}";

    @Test
    void 문자열로_부터_JsonObject_가져오기() {
        Optional<JsonObject> tbPublicWifiInfo = jsonParsingUtil.getJsonObject(testJson, "TbPublicWifiInfo");

        assertThat(tbPublicWifiInfo.get()).isInstanceOf(JsonObject.class);
    }

    @Test
    void list_total_count_가져오기() {
        Optional<JsonObject> tbPublicWifiInfo = jsonParsingUtil.getJsonObject(testJson, "TbPublicWifiInfo");

        int listTotalCount = jsonParsingUtil.getInt(tbPublicWifiInfo.get(), "list_total_count");
        assertThat(listTotalCount).isEqualTo(23406);
    }

    @Test
    void result_code_and_message_가져오기() {
        Optional<JsonObject> tbPublicWifiInfo = jsonParsingUtil.getJsonObject(testJson, "TbPublicWifiInfo");
        JsonObject result = jsonParsingUtil.getJsonObject(tbPublicWifiInfo.get(), "RESULT");
        String code = jsonParsingUtil.getString(result, "CODE");
        String message = jsonParsingUtil.getString(result, "MESSAGE");

        assertThat(code).isEqualTo("INFO-000");
        assertThat(message).isEqualTo("정상 처리되었습니다");
    }

    @Test
    void 데이터_범위_벗어났을때_리턴값_파싱() {
        JsonParser.parseString(endJsonData);
        JsonElement tbPublicWifiInfo = JsonParser.parseString(endJsonData).getAsJsonObject().get("TbPublicWifiInfo");

        assertThat(tbPublicWifiInfo).isNull();
    }
}