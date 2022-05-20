package com.feue.ml.repository;

import com.feue.ml.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-24 20:08
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getByChapterIdOrderByTime(Long chapterId);
}
