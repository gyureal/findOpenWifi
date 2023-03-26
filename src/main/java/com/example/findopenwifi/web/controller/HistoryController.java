package com.example.findopenwifi.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "historyController", urlPatterns = "/wifi/history")
public class HistoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/wifi/history");

        req.getRequestDispatcher("/WEB-INF/findOpenWifi/history.jsp")
                .forward(req, resp);
    }
}
