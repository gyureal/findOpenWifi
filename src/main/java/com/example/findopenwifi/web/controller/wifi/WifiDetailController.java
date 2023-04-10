package com.example.findopenwifi.web.controller.wifi;

import com.example.findopenwifi.domain.dto.OpenWifiInfoDTO;
import com.example.findopenwifi.domain.model.bookmark.BookmarkGroup;
import com.example.findopenwifi.domain.service.OpenWifiService;
import com.example.findopenwifi.domain.service.OpenWifiServiceImpl;
import com.example.findopenwifi.domain.service.bookmark.BookmarkGroupService;
import com.example.findopenwifi.domain.service.bookmark.BookmarkGroupServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "wifiDetailController", urlPatterns = "/wifi/detail")
public class WifiDetailController extends HttpServlet {

    OpenWifiService openWifiService = OpenWifiServiceImpl.INSTANCE;

    BookmarkGroupService bookmarkGroupService = BookmarkGroupServiceImpl.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mgrNo = req.getParameter("mgrNo");

        OpenWifiInfoDTO wifiInfo = openWifiService.getWifiInfo(mgrNo);
        List<BookmarkGroup> groupList = bookmarkGroupService.getAllBookmarkGroup();

        req.setAttribute("dto", wifiInfo);
        req.setAttribute("groupList", groupList);
        req.getRequestDispatcher("/WEB-INF/findOpenWifi/detail.jsp")
                .forward(req, resp);
    }
}
