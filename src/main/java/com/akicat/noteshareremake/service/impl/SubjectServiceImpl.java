package com.akicat.noteshareremake.service.impl;

import com.akicat.noteshareremake.mapper.SubjectMapper;
import com.akicat.noteshareremake.model.Subject;
import com.akicat.noteshareremake.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectMapper mapper;
    @Override
    public Subject getSubjectFromId(int id) {
        return mapper.getSubjectFromId(id);
    }

    @Override
    public List<Subject> getSubjectList() {
        return mapper.getSubjectList();
    }
}
