package com.akicat.noteshareremake.service.impl;

import com.akicat.noteshareremake.mapper.PayMapper;
import com.akicat.noteshareremake.model.PayDetail;
import com.akicat.noteshareremake.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    PayMapper payMapper;

    @Override
    public List<PayDetail> getPayDetailFromNoteId(int id) {
        return payMapper.getPayDetailFromNoteId(id);
    }

    @Override
    public int insertPayDetail(PayDetail payDetail) {
        return payMapper.insertPayDetail(payDetail);
    }

    @Override
    public int updatePayState(String payCode) {
        return payMapper.updatePayState(payCode);
    }
}
