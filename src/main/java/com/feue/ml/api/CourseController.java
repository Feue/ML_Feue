package com.feue.ml.api;

import com.feue.ml.dto.CourseDTO;
import com.feue.ml.entity.Course;
import com.feue.ml.service.CourseService;
import com.feue.ml.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-25 15:46
 */
@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET, value = "get/by/teacher_id/{teacher_id}")
    public UnifyResponse<List<Course>> getByTeacherId(@PathVariable(name = "teacher_id") Long teacherId) {
        List<Course> courseList = courseService.getByTeacherId(teacherId);
        return new UnifyResponse<>(courseList, "查询课程成功");
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public UnifyResponse add(@RequestBody CourseDTO dto) {
        courseService.add(dto);
        return new UnifyResponse("课程添加成功");
    }

    public UnifyResponse delete(Long id) {
        courseService.delete(id);
        return new UnifyResponse("课程删除成功");
    }
}
