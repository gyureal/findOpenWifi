package com.example.findopenwifi.domain.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpenWifiInfoDTO {

    private String manageNo;
    private double distance;

    private String dataDelYn;
    private Date dataRegDt;

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
