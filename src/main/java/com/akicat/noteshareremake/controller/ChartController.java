package com.akicat.noteshareremake.controller;

import com.akicat.noteshareremake.model.areaChart;
import com.akicat.noteshareremake.model.mapChart;
import com.akicat.noteshareremake.model.pieChart;
import com.akicat.noteshareremake.model.toneChart;
import com.akicat.noteshareremake.service.impl.ChartServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChartController {
    @Autowired
    ChartServiceImpl chartMapper;

    @RequestMapping("mapChart.action")
    @ResponseBody
    public List<mapChart> mapChart() throws JsonProcessingException {
        System.out.println("mapchart数据 "+chartMapper.getMapChart().toString());
        return chartMapper.getMapChart();
    }

    @RequestMapping("areaChart.action")
    @ResponseBody
    public List<areaChart> areaChart() throws JsonProcessingException {
        System.out.println("areachart数据 "+chartMapper.getAreaChart().toString());
        return chartMapper.getAreaChart();
    }

    @RequestMapping("pieChart.action")
    @ResponseBody
    public List<pieChart> pieChart() throws JsonProcessingException {
        System.out.println("piechart数据 "+chartMapper.getPieChart().toString());
        return chartMapper.getPieChart();
    }

    @RequestMapping("toneChart.action")
    @ResponseBody
    public List<toneChart> toneChart() throws JsonProcessingException {
        System.out.println("tonechart数据 "+chartMapper.getToneChart().toString());
        return chartMapper.getToneChart();
    }
}
