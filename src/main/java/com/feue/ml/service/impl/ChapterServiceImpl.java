package com.feue.ml.service.impl;

import com.feue.ml.dto.ChapterDTO;
import com.feue.ml.entity.Chapter;
import com.feue.ml.repository.ChapterRepository;
import com.feue.ml.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Feue
 * @create 2022-04-24 20:02
 */
@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    public void add(ChapterDTO dto) {
        Chapter chapter = Chapter.builder()
                .order(dto.getOrder())
                .name(dto.getName())
                .about(dto.getAbout())
                .courseId(dto.getCourseId())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .build();
        chapterRepository.save(chapter);
    }

    @Override
    public List<Chapter> getByCourseId(Long courseId) {
        return chapterRepository.getAllByCourseIdOrderByOrder(courseId);
    }

    @Override
    public void delete(Long id) {
        Chapter chapter = chapterRepository.getById(id);
        chapter.setDeleteTime(new Date());
        chapterRepository.save(chapter);
        // TODO: 删除章节对应视频
    }
}
