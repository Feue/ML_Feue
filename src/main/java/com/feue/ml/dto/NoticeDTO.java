package com.feue.ml.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Feue
 * @create 2022-04-25 16:31
 */
@Getter
@Setter
public class NoticeDTO {
    private String name;
    private String content;
    private Date time;
    private Long userId;
}
