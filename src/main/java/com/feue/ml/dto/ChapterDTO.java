package com.feue.ml.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Feue
 * @create 2022-04-24 19:52
 */
@Getter
@Setter
public class ChapterDTO {
    private Integer order;
    private String name;
    private String about;
    private Long courseId;
    private Date startTime;
    private Date endTime;
}
