package com.feue.ml.service.impl;

import com.feue.ml.dto.CommentDTO;
import com.feue.ml.entity.Comment;
import com.feue.ml.repository.CommentRepository;
import com.feue.ml.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Feue
 * @create 2022-04-24 20:48
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void add(CommentDTO dto) {
        Comment comment = Comment.builder()
                .userId(dto.getUserId())
                .content(dto.getContent())
                .level(dto.getLevel())
                .time(new Date())
                .chapterId(dto.getChapterId())
                .build();
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getByChapterId(Long chapterId) {
        return commentRepository.getByChapterIdOrderByTime(chapterId);
    }

    @Override
    public void delete(Long id) {
        Comment comment = commentRepository.getById(id);
        comment.setDeleteTime(new Date());
        commentRepository.save(comment);
    }
}
