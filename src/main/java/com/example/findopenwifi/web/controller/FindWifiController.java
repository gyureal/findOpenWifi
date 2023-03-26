package com.example.findopenwifi.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "findWifiController", urlPatterns = "/wifi/list")    // 맨 앞에 / 붙혀줘야함
public class FindWifiController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("/wifi/list");

        req.getRequestDispatcher("/WEB-INF/findOpenWifi/list.jsp")  // .jsp 붙혀줘야함
                .forward(req, resp);
    }
}
