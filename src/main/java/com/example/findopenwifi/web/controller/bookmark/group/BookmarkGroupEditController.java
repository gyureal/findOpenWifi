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

@WebServlet(name = "bookmarkGroupEditController", urlPatterns = "/wifi/bookmark-group-edit")
public class BookmarkGroupEditController extends HttpServlet {

    BookmarkGroupService bookmarkGroupService = BookmarkGroupServiceImpl.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        BookmarkGroup group = bookmarkGroupService.getOne(id);

        req.setAttribute("dto", group);
        req.getRequestDispatcher("/WEB-INF/findOpenWifi/bookmark/bookmark-group-edit.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String groupName = req.getParameter("groupName");
        int order = Integer.parseInt(req.getParameter("order"));

        int result = bookmarkGroupService.updateBookmarkGroup(id, BookmarkGroup.builder()
                .groupName(groupName)
                .order(order)
                .build());

        if (result <= 0) {
            resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
