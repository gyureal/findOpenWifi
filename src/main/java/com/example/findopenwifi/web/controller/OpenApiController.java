package com.example.findopenwifi.web.controller;

import com.example.findopenwifi.domain.service.OpenApiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "openApiController", urlPatterns = "/wifi/getOpenApi")
public class OpenApiController extends HttpServlet {

    private final OpenApiService openApiService;
    public OpenApiController() {
        this.openApiService = OpenApiService.INSTANCE;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int applyCount = openApiService.getAllOpenWifiData();
        System.out.println(applyCount);
    }
}
