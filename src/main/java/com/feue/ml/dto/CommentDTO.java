package com.feue.ml.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Feue
 * @create 2022-04-24 20:28
 */
@Getter
@Setter
public class CommentDTO {
    private Long userId;
    private String content;
    private Integer level;
    private Long chapterId;
}
