package com.feue.ml.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Feue
 * @create 2022-04-28 10:50
 */
@Getter
@Setter
public class VideoDTO {
    private Integer order;
    private String name;
    private String about;
    private String src;
    private Integer duration;
    private Long chapterId;
}
