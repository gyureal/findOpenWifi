package com.example.findopenwifi.persistence.jdbc.repositoryImpl;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import com.example.findopenwifi.domain.repository.OpenWifiInfoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OpenWifiInfoRepositoryImpl implements OpenWifiInfoRepository {
    @Override
    public String save(OpenWifiInfo openWifiInfo) {
        String dbFile = "/Users/yonggyujeong/myFolder/programing/db/sqlite/findOpenWifi.sqlite3";

        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;

        String returnValue = "";

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            String sql = "insert into openwifi (mgrNo, wrdofc, mainNm, adres1, adres2 " +
                    " , instlFloor, instlTy, instlMby, svcSe, cmcwr, cnstcYear" +
                    " ,inoutDoor, remars3, lat, lnt, workDttm) " +
                    " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            // SQL 수행
            stat = conn.prepareStatement(sql);
            stat.setString(1, openWifiInfo.getMgrNo());
            stat.setString(2, openWifiInfo.getWrdofc());
            stat.setString(3, openWifiInfo.getMainNm());
            stat.setString(4, openWifiInfo.getAdres1());
            stat.setString(5, openWifiInfo.getAdres2());
            stat.setString(6, openWifiInfo.getInstlFloor());
            stat.setString(7, openWifiInfo.getInstlTy());
            stat.setString(8, openWifiInfo.getInstlMby());
            stat.setString(9, openWifiInfo.getSvcSe());
            stat.setString(10, openWifiInfo.getCmcwr());
            stat.setString(11, openWifiInfo.getCnstcYear());
            stat.setString(12, openWifiInfo.getInoutDoor());
            stat.setString(13, openWifiInfo.getRemars3());
            stat.setDouble(14, openWifiInfo.getLat());
            stat.setDouble(15, openWifiInfo.getLnt());
            stat.setString(16, openWifiInfo.getWorkDttm());

            int affected = stat.executeUpdate();

            if (affected > 0) {
                returnValue = openWifiInfo.getMgrNo();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (stat != null && !stat.isClosed()) {
                    stat.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return returnValue;
    }

    @Override
    public List<OpenWifiInfo> findAll() {
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<OpenWifiInfo> openWifiInfoList = new ArrayList<>();

        String dbFile = "/Users/yonggyujeong/myFolder/programing/db/sqlite/findOpenWifi.sqlite3";

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            String sql = "select * from openwifi";

            // SQL 수행
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                OpenWifiInfo openWifiInfo = OpenWifiInfo.builder()
                        .mgrNo(rs.getString("mgrNo"))
                        .wrdofc(rs.getString("wrdofc"))
                        .mainNm(rs.getString("mainNm"))
                        .adres1(rs.getString("adres1"))
                        .adres2(rs.getString("adres2"))
                        .instlFloor(rs.getString("instlFloor"))
                        .instlTy(rs.getString("instlTy"))
                        .instlMby(rs.getString("instlMby"))
                        .svcSe(rs.getString("svcSe"))
                        .cmcwr(rs.getString("cmcwr"))
                        .cnstcYear(rs.getString("cnstcYear"))
                        .inoutDoor(rs.getString("inoutDoor"))
                        .remars3(rs.getString("remars3"))
                        .lat(rs.getDouble("lat"))
                        .lnt(rs.getDouble("lnt"))
                        .workDttm(rs.getString("workDttm"))
                        .dataDelYn(rs.getString("dataDelYn"))
                        .dataRegDt(rs.getString("dataRegDt"))
                        .build();

                openWifiInfoList.add(openWifiInfo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (stat != null && !stat.isClosed()) {
                    stat.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return openWifiInfoList;
    }
}
