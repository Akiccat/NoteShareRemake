package com.akicat.noteshareremake;

import com.akicat.noteshareremake.mapper.ChartMapper;
import com.akicat.noteshareremake.mapper.UserMapper;
import com.akicat.noteshareremake.model.User;
import com.akicat.noteshareremake.service.impl.ChartServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoteShareRemakeApplicationTests {
    @Autowired
    ChartServiceImpl chartMapper;
    @Test
    void contextLoads() {
        System.out.println(chartMapper.getToneChart().toString());
    }

}
