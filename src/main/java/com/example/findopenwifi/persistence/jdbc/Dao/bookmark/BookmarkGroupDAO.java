package com.example.findopenwifi.persistence.jdbc.Dao.bookmark;

import com.example.findopenwifi.domain.model.SearchHistory;
import com.example.findopenwifi.domain.model.bookmark.BookmarkGroup;
import com.example.findopenwifi.domain.repository.bookmark.BookmarkGroupRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookmarkGroupDAO implements BookmarkGroupRepository {

    private static String dbFile = "/Users/yonggyujeong/myFolder/programing/db/sqlite/findOpenWifi.sqlite3";

    @Override
    public int save(BookmarkGroup bookmarkGroup) {
        checkDbDriver();

        String sql = "insert into bookmark_group(group_name, orderNum)" +
                "values (?, ?)";

        int rows = 0;
        try(Connection conn =  DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql);) {
            stat.setString(1, bookmarkGroup.getGroupName());
            stat.setInt(2, bookmarkGroup.getOrder());
            rows = stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(rows);
        return rows;
    }

    @Override
    public List<BookmarkGroup> findAll() {
        checkDbDriver();

        String sql = "select * from bookmark_group where data_del_yn != 'Y' order by id";

        List<BookmarkGroup> list = new ArrayList<>();

        try(Connection conn =  DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql);) {
            try(ResultSet rs = stat.executeQuery();) {
                while (rs.next()) {
                    BookmarkGroup group = BookmarkGroup.builder()
                            .id(rs.getInt("id"))
                            .groupName(rs.getString("group_name"))
                            .order(rs.getInt("orderNum"))
                            .dataRegDate(rs.getString("data_reg_date"))
                            .dataUpdDate(rs.getString("data_upd_date"))
                            .build();

                    list.add(group);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public BookmarkGroup findOne(int id) {
        checkDbDriver();

        String sql = "select * from bookmark_group where id = ? and data_del_yn = 'N'";

        try(Connection conn =  DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql);) {
            stat.setInt(1, id);
            try(ResultSet rs = stat.executeQuery();) {
                while (rs.next()) {
                    BookmarkGroup group = BookmarkGroup.builder()
                            .id(rs.getInt("id"))
                            .groupName(rs.getString("group_name"))
                            .order(rs.getInt("orderNum"))
                            .dataRegDate(rs.getString("data_reg_date"))
                            .dataUpdDate(rs.getString("data_upd_date"))
                            .build();
                    return group;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(int id, BookmarkGroup bookmarkGroup) {
        checkDbDriver();

        String sql = "update bookmark_group " +
                "set group_name = ?, orderNum = ?, data_upd_date = (datetime('now', 'localtime')) " +
                "where id = ?";

        int rows = -1;
        try(Connection conn =  DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql);) {
            stat.setString(1, bookmarkGroup.getGroupName());
            stat.setInt(2, bookmarkGroup.getOrder());
            stat.setInt(3, id);
            rows = stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        checkDbDriver();
        String sql = "update bookmark_group set data_del_yn = 'Y' where id = ?";

        int rows = -1;
        try(Connection conn =  DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql);) {
            stat.setInt(1, id);
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
