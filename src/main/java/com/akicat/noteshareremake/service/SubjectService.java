package com.akicat.noteshareremake.service;

import com.akicat.noteshareremake.model.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SubjectService {
    public Subject getSubjectFromId(@Param("subject_id") int id);
    public List<Subject> getSubjectList();
}
