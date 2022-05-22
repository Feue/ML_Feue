package com.feue.ml.vo;

import com.feue.ml.entity.Video;
import lombok.*;

/**
 * @author Feue
 * @create 2022-05-21 22:04
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoVO {
    private Long id;
    private Integer order;
    private String name;
    private String about;
    private String src;
    private Integer duration;
    private String chapterName;

    public VideoVO(Video video, String chapterName) {
        this(video.getId(), video.getOrder(), video.getName(), video.getAbout(),
                video.getSrc(), video.getDuration(), chapterName);
    }
}
