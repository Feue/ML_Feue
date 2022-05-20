package com.feue.ml.repository;

import com.feue.ml.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-24 19:50
 */
public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    List<Chapter> getAllByCourseIdOrderByOrder(Long courseId);
}
