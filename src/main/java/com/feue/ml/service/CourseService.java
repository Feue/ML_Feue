package com.feue.ml.service;

import com.feue.ml.dto.CourseDTO;
import com.feue.ml.entity.Course;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-25 15:45
 */
public interface CourseService {
    List<Course> getByTeacherId(Long teacherId);

    void add(CourseDTO dto);

    void delete(Long id);

    List<Course> get();

    List<Course> getByStudentId(Long studentId);
}
