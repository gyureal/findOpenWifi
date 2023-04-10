package com.example.findopenwifi.web.controller.wifi;

import com.example.findopenwifi.domain.dto.OpenWifiInfoDTO;
import com.example.findopenwifi.domain.model.OpenWifiInfo;
import com.example.findopenwifi.domain.service.OpenWifiService;
import com.example.findopenwifi.domain.service.OpenWifiServiceImpl;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "findWifiController", urlPatterns = "/wifi/list")    // 맨 앞에 / 붙혀줘야함
@Log4j2
public class FindWifiController extends HttpServlet {

    OpenWifiService openWifiService = OpenWifiServiceImpl.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/wifi/list");

        req.setAttribute("dtoList", new ArrayList<OpenWifiInfoDTO>());

        req.getRequestDispatcher("/WEB-INF/findOpenWifi/list.jsp")  // .jsp 붙혀줘야함
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        double x = Double.parseDouble(req.getParameter("lnt"));
        double y = Double.parseDouble(req.getParameter("lat"));

        List<OpenWifiInfoDTO> dto = openWifiService.getWifiNearBy(x, y);

        req.setAttribute("dtoList", dto);
        req.getRequestDispatcher("/WEB-INF/findOpenWifi/list.jsp")
                .forward(req, resp);
    }
}
