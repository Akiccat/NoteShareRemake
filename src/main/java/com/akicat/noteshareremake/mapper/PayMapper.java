package com.akicat.noteshareremake.mapper;

import com.akicat.noteshareremake.model.PayDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;

import java.util.List;

@Mapper
public interface PayMapper {
    List<PayDetail> getPayDetailFromNoteId(int id);
    int insertPayDetail(PayDetail payDetail);
    int updatePayState(String payCode);
}
