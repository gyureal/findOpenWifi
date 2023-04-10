package com.example.findopenwifi.web.controller.openapi;

import com.example.findopenwifi.domain.service.OpenApiService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "openApiController", urlPatterns = "/wifi/openApi")
@Log4j2
public class OpenApiController extends HttpServlet {

    private final OpenApiService openApiService;
    public OpenApiController() {
        this.openApiService = OpenApiService.INSTANCE;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int applyCount = openApiService.getAllOpenWifiData();
        log.info(applyCount);

        req.setAttribute("applyCount", applyCount);
        req.getRequestDispatcher("/WEB-INF/findOpenWifi/searchFinished.jsp")
                .forward(req, resp);

    }
}
