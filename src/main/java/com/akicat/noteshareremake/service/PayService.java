package com.akicat.noteshareremake.service;

import com.akicat.noteshareremake.model.PayDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface PayService {
    List<PayDetail> getPayDetailFromNoteId(int id);
    int insertPayDetail(PayDetail payDetail);
    int updatePayState(String payCode);
}
