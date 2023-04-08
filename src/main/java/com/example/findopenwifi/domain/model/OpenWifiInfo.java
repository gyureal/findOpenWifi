package com.example.findopenwifi.domain.model;

import com.example.findopenwifi.domain.dto.RawWifiInfoObject;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class OpenWifiInfo {

    private int id;

    private String dataDelYn;
    private String dataRegDt;

    /* 오픈 API 포털 데이터 */
    private String mgrNo;
    private String wrdofc;
    private String mainNm;
    private String adres1;
    private String adres2;
    private String instlFloor;
    private String instlTy;
    private String instlMby;
    private String svcSe;
    private String cmcwr;
    private String cnstcYear;
    private String inoutDoor;
    private String remars3;
    private double lat;     // Y 좌표
    private double lnt;     // X 좌표
    private String workDttm;

    public double calculateDistance(double x, double y) {
        double xDiff = Math.abs(x - lnt);
        double yDiff = Math.abs(y - lat);
        return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }

    public static OpenWifiInfo from(RawWifiInfoObject raw) {
        return OpenWifiInfo.builder()
                .mgrNo(raw.getX_SWIFI_MGR_NO())
                .wrdofc(raw.getX_SWIFI_WRDOFC())
                .mainNm(raw.getX_SWIFI_MAIN_NM())
                .adres1(raw.getX_SWIFI_ADRES1())
                .adres2(raw.getX_SWIFI_ADRES2())
                .instlFloor(raw.getX_SWIFI_INSTL_FLOOR())
                .instlTy(raw.getX_SWIFI_INSTL_TY())
                .instlMby(raw.getX_SWIFI_INSTL_MBY())
                .svcSe(raw.getX_SWIFI_SVC_SE())
                .cmcwr(raw.getX_SWIFI_CMCWR())
                .cnstcYear(raw.getX_SWIFI_CNSTC_YEAR())
                .inoutDoor(raw.getX_SWIFI_INOUT_DOOR())
                .remars3(raw.getX_SWIFI_REMARS3())
                .lat(raw.getLAT())
                .lnt(raw.getLNT())
                .workDttm(raw.getWORK_DTTM())
                .build();
    }

}
