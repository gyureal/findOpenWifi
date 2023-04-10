package com.example.findopenwifi.persistence.jdbc.Dao.bookmark;

import com.example.findopenwifi.domain.model.bookmark.Bookmark;
import com.example.findopenwifi.domain.model.bookmark.BookmarkGroup;
import com.example.findopenwifi.domain.repository.bookmark.BookmarkRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookmarkDAO implements BookmarkRepository {

    private static String dbFile = "/Users/yonggyujeong/myFolder/programing/db/sqlite/findOpenWifi.sqlite3";
    @Override
    public List<Bookmark> findAll() {
        checkDbDriver();

        String sql = "select bookmark.id " +
                " , bookmark.bookmark_group_id " +
                " , bookmark_group.group_name " +
                " , bookmark.mgrNo " +
                " , openwifi.mainNm " +
                " , bookmark.data_reg_date " +
                "  from bookmark " +
                " inner join bookmark_group  " +
                "    on bookmark.bookmark_group_id = bookmark_group.id " +
                "    and bookmark_group.data_del_yn != 'Y' " +
                " inner join openwifi  " +
                "    on bookmark.mgrNo = openwifi.mgrNo " +
                " where bookmark.data_del_yn != 'Y' " +
                " order by bookmark.id ";

        List<Bookmark> list = new ArrayList<>();

        try(Connection conn =  DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql);) {
            try(ResultSet rs = stat.executeQuery();) {
                while (rs.next()) {
                    Bookmark bookmark = Bookmark.builder()
                            .id(rs.getInt("id"))
                            .bookmarkGroupId(rs.getInt("bookmark_group_id"))
                            .bookmarkGroupName(rs.getString("group_name"))
                            .mgrNo(rs.getString("mgrNo"))
                            .mgrName(rs.getString("mainNm"))
                            .dataDelYn(rs.getString("data_reg_date"))
                            .build();

                    list.add(bookmark);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int insert(Bookmark bookmark) {
        checkDbDriver();

        String sql = "insert into bookmark(bookmark_group_id, mgrNo)" +
                "values (?, ?)";

        int rows = 0;
        try(Connection conn =  DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            PreparedStatement stat = conn.prepareStatement(sql);) {
            stat.setInt(1, bookmark.getBookmarkGroupId());
            stat.setString(2, bookmark.getMgrNo());
            rows = stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        checkDbDriver();
        String sql = "update bookmark set data_del_yn = 'Y' where id = ?";

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
