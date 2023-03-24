package com.akicat.noteshareremake.mapper;

import com.akicat.noteshareremake.model.areaChart;
import com.akicat.noteshareremake.model.mapChart;
import com.akicat.noteshareremake.model.pieChart;
import com.akicat.noteshareremake.model.toneChart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
public interface ChartMapper {
    public List<mapChart> getMapChart();
    public List<areaChart> getAreaChart();
    public List<pieChart> getPieChart();
    public List<toneChart> getToneChart();

}
