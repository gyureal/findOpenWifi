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
import java.util.List;

@WebServlet(name = "bookmarkGroupController", urlPatterns = "/wifi/bookmark-group")
public class BookmarkGroupController extends HttpServlet {

    private final BookmarkGroupService bookmarkGroupService = BookmarkGroupServiceImpl.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<BookmarkGroup> allBookmarkGroup = bookmarkGroupService.getAllBookmarkGroup();

        req.setAttribute("groupList", allBookmarkGroup);

        req.getRequestDispatcher("/WEB-INF/findOpenWifi/bookmark/bookmark-group-list.jsp")
                .forward(req, resp);
    }
}
