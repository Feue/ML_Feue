package com.feue.ml.api;

import com.feue.ml.dto.CourseDTO;
import com.feue.ml.entity.Course;
import com.feue.ml.service.CategoryService;
import com.feue.ml.service.CourseService;
import com.feue.ml.service.UserService;
import com.feue.ml.vo.CourseVO;
import com.feue.ml.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public UnifyResponse<List<Course>> get() {
        List<Course> courseList = courseService.get();
        return new UnifyResponse<>(courseList, "查询课程成功");
    }

    @RequestMapping(method = RequestMethod.GET, value = "student_id/{student_id}")
    public UnifyResponse<List<CourseVO>> getByStudentId(@PathVariable(name = "student_id") Long studentId) {
        List<Course> courseList = courseService.getByStudentId(studentId);
        List<Long> userIds = new ArrayList<>();
        List<Long> categoryIds = new ArrayList<>();
        courseList.forEach(course -> {
            userIds.add(course.getUserId());
            categoryIds.add(course.getCategoryId());
        });
        List<String> teacherNames = userService.findAllTeacherNameByIds(userIds);
        List<String> categories = categoryService.findAllCategoryNameByIds(categoryIds);
        List<CourseVO> vos = new ArrayList<>();
        for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);
            String teacherName = teacherNames.get(i);
            String category = categories.get(i);
            vos.add(new CourseVO(course, teacherName, category));
        }
        return new UnifyResponse<>(vos, "查询课程成功");
    }

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
