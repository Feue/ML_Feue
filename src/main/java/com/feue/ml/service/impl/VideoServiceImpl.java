package com.feue.ml.service.impl;

import com.feue.ml.dto.VideoDTO;
import com.feue.ml.entity.Video;
import com.feue.ml.repository.VideoRepository;
import com.feue.ml.service.VideoService;
import com.feue.ml.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Feue
 * @create 2022-04-28 10:22
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<Video> getByChapterId(Long chapterId) {
        return videoRepository.findAllByChapterId(chapterId);
    }

    @Override
    public void add(VideoDTO dto) {
        Video video = Video.builder()
                .order(dto.getOrder())
                .name(dto.getName())
                .about(dto.getAbout())
                .src(dto.getSrc())
                .duration(dto.getDuration())
                .chapterId(dto.getChapterId())
                .build();
        videoRepository.save(video);
    }

    @Override
    public void delete(Long id) {
        Video video = videoRepository.getById(id);
        video.setDeleteTime(new Date());
        videoRepository.save(video);
    }
}
