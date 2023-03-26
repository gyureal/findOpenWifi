package com.example.findopenwifi.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

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
    private double lat;
    private double lnt;
    private String workDttm;

}
