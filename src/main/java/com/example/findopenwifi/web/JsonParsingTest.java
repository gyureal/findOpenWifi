package com.example.findopenwifi.web;

import com.example.findopenwifi.web.dto.JsonObjectWifiInfo;
import com.google.gson.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonParsingTest {

    @Test
    void JsonParserTest() {
        String jsonData = "{\n" +
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
        JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();
        System.out.println(jsonObject);

        JsonObject tbPublicWifiInfo = jsonObject.get("TbPublicWifiInfo").getAsJsonObject();

        // list_total_count
        int listTotalCount = tbPublicWifiInfo.get("list_total_count").getAsInt();
        System.out.println(listTotalCount);

        JsonArray row = tbPublicWifiInfo.get("row").getAsJsonArray();

        // row
        String rowObject = row.get(0).toString();
        Gson gson = new Gson();
        JsonObjectWifiInfo jsonObjectWifiInfo = gson.fromJson(rowObject, JsonObjectWifiInfo.class);

        System.out.println(jsonObjectWifiInfo.getX_SWIFI_MGR_NO());


    }

}