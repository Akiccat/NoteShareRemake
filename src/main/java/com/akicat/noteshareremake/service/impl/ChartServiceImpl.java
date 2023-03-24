package com.akicat.noteshareremake.service.impl;

import com.akicat.noteshareremake.mapper.ChartMapper;
import com.akicat.noteshareremake.mapper.SubjectMapper;
import com.akicat.noteshareremake.mapper.UserMapper;
import com.akicat.noteshareremake.model.*;
import com.akicat.noteshareremake.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChartServiceImpl implements ChartService {
    @Autowired
    private ChartMapper chartMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<mapChart> getMapChart() {
        return chartMapper.getMapChart();
    }
    @Override
    public List<areaChart> getAreaChart() {
        List<areaChart> list = chartMapper.getAreaChart();
        for (areaChart areaChart : list) {
            areaChart.setName(subjectMapper.getSubjectFromId(Integer.parseInt(areaChart.getName())).getName());
        }
        return list;
    }

    @Override
    public List<pieChart> getPieChart() {
        List<pieChart> list = chartMapper.getPieChart();
        for (pieChart pieChart : list) {
            if(pieChart.getName().equals("1")){
                pieChart.setName("女");
            }else {
                pieChart.setName("男");
            }
        }
        return list;
    }

    @Override
    public List<toneChart> getToneChart() {
        List<toneChart> list = chartMapper.getToneChart();
        for (toneChart toneChart : list) {
            toneChart.setName(userMapper.getUserFromUserId(Integer.parseInt(toneChart.getName())).getUser_name());
        }
        return list;
    }
}
