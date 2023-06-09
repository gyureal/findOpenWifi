package com.example.findopenwifi.web.controller.bookmark.group;

import com.example.findopenwifi.domain.model.bookmark.BookmarkGroup;
import com.example.findopenwifi.domain.service.bookmark.BookmarkGroupService;
import com.example.findopenwifi.domain.service.bookmark.BookmarkGroupServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookmarkGroupAddController", urlPatterns = "/wifi/bookmark-group-add")
public class BookmarkGroupAddController extends HttpServlet {

    BookmarkGroupService bookmarkGroupService = BookmarkGroupServiceImpl.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("도달");
        req.getRequestDispatcher("/WEB-INF/findOpenWifi/bookmark/bookmark-group-add.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("add post 도달");

        String groupName = req.getParameter("groupName");
        int order = Integer.parseInt(req.getParameter("order"));

        int result = bookmarkGroupService.addBookmarkGroup(BookmarkGroup.builder()
                        .groupName(groupName)
                        .order(order)
                        .build());
        if (result <= 0) {
            resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
