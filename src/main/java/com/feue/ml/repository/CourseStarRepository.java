package com.feue.ml.repository;

import com.feue.ml.entity.CourseStar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Feue
 * @create 2022-05-20 20:29
 */
public interface CourseStarRepository extends JpaRepository<CourseStar, Long> {
    List<CourseStar> findAllByUserId(Long userId);
}
