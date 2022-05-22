package com.feue.ml.service.impl;

import com.feue.ml.dto.CourseDTO;
import com.feue.ml.entity.Course;
import com.feue.ml.entity.CourseStar;
import com.feue.ml.repository.CourseRepository;
import com.feue.ml.repository.CourseStarRepository;
import com.feue.ml.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Feue
 * @create 2022-04-25 16:10
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseStarRepository courseStarRepository;

    @Override
    public List<Course> get() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getByStudentId(Long studentId) {
        List<Long> courseIds = new ArrayList<>();
        List<CourseStar> courseStarList = courseStarRepository.findAllByUserId(studentId);
        courseStarList.forEach(cs -> courseIds.add(cs.getCourseId()));
        return courseRepository.findAllById(courseIds);
    }

    @Override
    public List<Course> getByTeacherId(Long teacherId) {
        return courseRepository.findAllByUserId(teacherId);
    }

    @Override
    public void add(CourseDTO dto) {
        Course course = Course.builder()
                .name(dto.getName())
                .about(dto.getAbout())
                .userId(dto.getUserId())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .categoryId(dto.getCategoryId())
                .build();
        courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        Course course = courseRepository.getById(id);
        course.setDeleteTime(new Date());
        courseRepository.save(course);
        // TODO: 删除对应章节

        // TODO: 删除对应视频
    }
}
