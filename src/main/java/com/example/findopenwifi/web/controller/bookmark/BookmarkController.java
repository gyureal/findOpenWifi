package com.example.findopenwifi.web.controller.bookmark;

import com.example.findopenwifi.domain.model.bookmark.Bookmark;
import com.example.findopenwifi.domain.service.bookmark.BookmarkService;
import com.example.findopenwifi.domain.service.bookmark.BookmarkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "bookmarkController", urlPatterns = "/wifi/bookmark-list")
public class BookmarkController extends HttpServlet {

    BookmarkService bookmarkService = BookmarkServiceImpl.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Bookmark> bookmarkList = bookmarkService.getAllBookmark();
        req.setAttribute("bookmarkList", bookmarkList);

        req.getRequestDispatcher("/WEB-INF/findOpenWifi/bookmark/bookmark-list.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int result = bookmarkService.delete(id);

        if (result <= 0) {
            resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
