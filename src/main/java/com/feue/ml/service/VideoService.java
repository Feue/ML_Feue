package com.feue.ml.service;

import com.feue.ml.dto.VideoDTO;
import com.feue.ml.entity.Video;
import com.feue.ml.vo.UnifyResponse;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-25 16:53
 */
public interface VideoService {
    List<Video> getByChapterId(Long chapterId);

    void delete(Long id);

    void add(VideoDTO dto);
}
