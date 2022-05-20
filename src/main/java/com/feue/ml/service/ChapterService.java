package com.feue.ml.service;

import com.feue.ml.dto.ChapterDTO;
import com.feue.ml.entity.Chapter;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-24 19:50
 */
public interface ChapterService {
    void add(ChapterDTO dto);

    List<Chapter> getByCourseId(Long courseId);

    void delete(Long id);
}
