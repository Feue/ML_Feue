package com.feue.ml.repository;

import com.feue.ml.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-25 16:53
 */
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findAllByChapterId(Long chapterId);
}
