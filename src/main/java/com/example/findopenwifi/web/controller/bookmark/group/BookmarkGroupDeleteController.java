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

@WebServlet(name = "bookmarkGroupDeleteController", urlPatterns = "/wifi/bookmark-group-delete")
public class BookmarkGroupDeleteController extends HttpServlet {

    BookmarkGroupService bookmarkGroupService = BookmarkGroupServiceImpl.INSTANCE;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        int result = bookmarkGroupService.deleteBookmarkGroup(id);
        if (result <= 0) {
            resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
