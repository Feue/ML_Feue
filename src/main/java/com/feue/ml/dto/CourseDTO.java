package com.feue.ml.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Feue
 * @create 2022-04-25 16:06
 */
@Getter
@Setter
public class CourseDTO {
    private String name;
    private String about;
    private Long userId;
    private Date startTime;
    private Date endTime;
    private Long categoryId;
}
