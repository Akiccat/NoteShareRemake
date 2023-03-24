package com.akicat.noteshareremake.mapper;

import com.akicat.noteshareremake.model.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectMapper {
    public Subject getSubjectFromId(@Param("subject_id") int id);
    public List<Subject> getSubjectList();
}
