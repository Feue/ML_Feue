package com.feue.ml.vo;

import com.feue.ml.entity.Course;
import lombok.*;

import java.util.Date;

/**
 * @author Feue
 * @create 2022-05-21 10:10
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseVO {
    private Long id;
    private String name;
    private String about;
    private String teacherName;
    private Date startTime;
    private Date endTime;
    private String category;
    private String coverImage;

    public CourseVO(Course course, String teacherName, String category) {
        this(course.getId(), course.getName(), course.getAbout(),teacherName,
                course.getStartTime(), course.getEndTime(), category, course.getCoverImage());
    }
}
