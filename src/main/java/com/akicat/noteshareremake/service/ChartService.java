package com.akicat.noteshareremake.service;

import com.akicat.noteshareremake.model.areaChart;
import com.akicat.noteshareremake.model.mapChart;
import com.akicat.noteshareremake.model.pieChart;
import com.akicat.noteshareremake.model.toneChart;

import java.util.List;

public interface ChartService {
    public List<mapChart> getMapChart();
    public List<areaChart> getAreaChart();
    public List<pieChart> getPieChart();
    public List<toneChart> getToneChart();
}
