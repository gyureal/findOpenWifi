package com.example.findopenwifi.persistence.jdbc.Dao;

import com.example.findopenwifi.domain.model.SearchHistory;
import com.example.findopenwifi.domain.repository.SearchHistoryRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchHistoryDAO implements SearchHistoryRepository {

    private static String dbFile = "/Users/yonggyujeong/myFolder/programing/db/sqlite/findOpenWifi.sqlite3";

    @Override
    public int getNextAutoIncrementId() {
        checkDbDriver();

        String sql = "select max(id) as id from searchHistory";

        int nextId = -1;
        try(Connection conn =  DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql);) {
            try(ResultSet rs = stat.executeQuery();) {
                while (rs.next()) {
                    nextId = rs.getInt("id") + 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextId;
    }

    @Override
    public int save(SearchHistory searchHistory) {
        checkDbDriver();

        String sql = "insert into searchHistory(x_value, y_value)\n" +
                "values (?, ?)";

        int rows = 0;
        try(Connection conn =  DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql);) {
            stat.setDouble(1, searchHistory.getXValue());
            stat.setDouble(2, searchHistory.getYValue());
            rows = stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<SearchHistory> findAll() {
        checkDbDriver();

        String sql = "select * from searchHistory where data_del_yn != 'Y'";

        List<SearchHistory> list = new ArrayList<>();

        try(Connection conn =  DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql);) {
            try(ResultSet rs = stat.executeQuery();) {
                while (rs.next()) {
                    SearchHistory history = SearchHistory.builder()
                            .id(rs.getInt("id"))
                            .xValue(rs.getDouble("x_value"))
                            .yValue(rs.getDouble("y_value"))
                            .searchDateTime(rs.getString("searchDatetime"))
                            .dataDelYn(rs.getString("data_del_yn"))
                            .build();
                    list.add(history);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Optional<SearchHistory> findById(int id) {
        checkDbDriver();

        String sql = "select * from searchHistory where id = ? and data_del_yn = 'N'";

        try(Connection conn =  DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql);) {
            stat.setInt(1, id);
            try(ResultSet rs = stat.executeQuery();) {
                while (rs.next()) {
                    SearchHistory history = SearchHistory.builder()
                            .id(rs.getInt("id"))
                            .xValue(rs.getDouble("x_value"))
                            .yValue(rs.getDouble("y_value"))
                            .searchDateTime(rs.getString("searchDatetime"))
                            .dataDelYn(rs.getString("data_del_yn"))
                            .build();
                    return Optional.of(history);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public int delete(int id) {
        checkDbDriver();

        String sql = "update searchHistory set data_del_yn = 'Y' where id = ?";

        int rows = -1;
        try(Connection conn =  DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql);) {
            stat.setDouble(1, id);
            rows = stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    private static void checkDbDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
