/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.onsemi.dans.controller;

import com.onsemi.dans.model.CanvasData;
import com.onsemi.dans.model.CanvasDataAnimation;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author zbqb9x
 */
@Controller
@RequestMapping("/canvasjschart")
@SessionAttributes({"userSession"})
public class CanvasController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CanvasController.class);
    String[] args = {};

//    @RequestMapping(method = RequestMethod.GET)
    @RequestMapping(value = "/viewZoom", method = RequestMethod.GET)
    public String springMVC(ModelMap modelMap) {
        List<List<Map<Object, Object>>> canvasjsDataList = CanvasData.getCanvasjsDataList();

        LOGGER.info("LOGGER for xxx : " + canvasjsDataList);
        modelMap.addAttribute("dataPointsList", canvasjsDataList);
        return "chart/chart";
    }

//    <editor-fold defaultstate="collapsed" desc="Json Data">
//    @RequestMapping(method = RequestMethod.GET)
    @RequestMapping(value = "/viewJson", method = RequestMethod.GET)
    public String springMVCJSONDATA(ModelMap modelMap) {
        return "chart/chartJson";
    }

//    @RequestMapping(method = RequestMethod.GET)
    @RequestMapping(value = "/viewAnimation", method = RequestMethod.GET)
    public String springMVCAnimation(ModelMap modelMap) {
//        List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
        List<List<Map<Object, Object>>> canvasjsDataList = CanvasDataAnimation.getCanvasjsDataListAnimation();
        modelMap.addAttribute("dataPointsList", canvasjsDataList);
        return "chart/chartAnimation";
    }

}
