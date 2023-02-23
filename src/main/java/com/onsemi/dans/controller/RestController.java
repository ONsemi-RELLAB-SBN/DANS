/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.onsemi.dans.controller;


import com.onsemi.dans.model.CanvasData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.canvasjs.chart.services.CanvasjsChartService;
/**
 *
 * @author zbqb9x
 */
@Controller
@RequestMapping(value = "/restfull-service")
public class RestController extends HttpServlet {

    private static final long serialVersionUID = 1L;

//    @Autowired
//    private CanvasjsChartService canvasjsChartService;

    @RequestMapping(value = "/letter-frequency-of-vowels-in-english.json", method = RequestMethod.GET)
    public @ResponseBody
    String getDataPoints(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data = CanvasData.getCanvasjsDataListJson();
//        return canvasjsChartService.getCanvasjsChartData();
        return data;
    }
}
