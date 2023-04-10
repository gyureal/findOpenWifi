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

@WebServlet(name = "bookmarkAddController", urlPatterns = "/wifi/bookmark-add")
public class BookmarkAddController extends HttpServlet {

    BookmarkService bookmarkService = BookmarkServiceImpl.INSTANCE;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mgrNo = req.getParameter("mgrNo");
        int groupId = Integer.parseInt(req.getParameter("groupId"));

        int result = bookmarkService.addBookmark(Bookmark.builder()
                .bookmarkGroupId(groupId)
                .mgrNo(mgrNo)
                .build());

        if (result <= 0) {
            resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        }
        resp.setStatus(HttpServletResponse.SC_OK);

    }
}
