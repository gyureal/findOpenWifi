package com.example.findopenwifi.persistence.jdbc.Dao;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import com.example.findopenwifi.domain.repository.OpenWifiInfoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OpenWifiInfoDAO implements OpenWifiInfoRepository {

    private static String dbFile = "/Users/yonggyujeong/myFolder/programing/db/sqlite/findOpenWifi.sqlite3";
    @Override
    public String save(OpenWifiInfo openWifiInfo) {
        checkDbDriver();

        String sql = "insert into openwifi (mgrNo, wrdofc, mainNm, adres1, adres2 " +
                " , instlFloor, instlTy, instlMby, svcSe, cmcwr, cnstcYear" +
                " ,inoutDoor, remars3, lat, lnt, workDttm) " +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql)) {

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
                return openWifiInfo.getMgrNo();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public List<OpenWifiInfo> findAll() {
        checkDbDriver();

        String sql = "select * from openwifi";

        List<OpenWifiInfo> openWifiInfoList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
             PreparedStatement stat = conn.prepareStatement(sql)) {
            try (ResultSet rs = stat.executeQuery()) {
                while (rs.next()) {
                    OpenWifiInfo openWifiInfo = OpenWifiInfo.builder()
                            .id(rs.getInt("id"))
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return openWifiInfoList;
    }

    @Override
    public OpenWifiInfo findByMgrNo(String mgrNo) {
        checkDbDriver();

        String sql = "select * from openwifi where mgrNo = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
             PreparedStatement stat = conn.prepareStatement(sql)) {

            stat.setString(1, mgrNo);
            try (ResultSet rs = stat.executeQuery()) {
                while (rs.next()) {
                    return OpenWifiInfo.builder()
                            .id(rs.getInt("id"))
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
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteAll() {
        checkDbDriver();

        String sql = "delete from openwifi";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
             PreparedStatement stat = conn.prepareStatement(sql)) {

            stat.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void checkDbDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
