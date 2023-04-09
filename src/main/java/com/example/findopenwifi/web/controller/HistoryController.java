package com.example.findopenwifi.web.controller;

import com.example.findopenwifi.domain.dto.SearchHistoryDTO;
import com.example.findopenwifi.domain.service.HistoryService;
import com.example.findopenwifi.domain.service.HistoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "historyController", urlPatterns = "/wifi/history")
public class HistoryController extends HttpServlet {

    HistoryService historyService = HistoryServiceImpl.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<SearchHistoryDTO> dtoList = historyService.searchAllHistory();

        req.setAttribute("dtoList", dtoList);
        req.getRequestDispatcher("/WEB-INF/findOpenWifi/history.jsp")
                .forward(req, resp);
    }
}
