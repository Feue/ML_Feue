package com.feue.ml.repository;

import com.feue.ml.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-25 15:45
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByUserId(Long userId);
}
