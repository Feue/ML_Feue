package com.feue.ml.service;

import com.feue.ml.dto.CommentDTO;
import com.feue.ml.entity.Comment;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-24 20:08
 */
public interface CommentService {
    void add(CommentDTO dto);

    List<Comment> getByChapterId(Long chapterId);

    void delete(Long id);
}
