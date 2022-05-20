package com.feue.ml.api;

import com.feue.ml.dto.CommentDTO;
import com.feue.ml.entity.Comment;
import com.feue.ml.service.CommentService;
import com.feue.ml.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-24 20:09
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public UnifyResponse add(@RequestBody CommentDTO dto) {
        commentService.add(dto);
        return new UnifyResponse("评价添加成功");
    }

    @RequestMapping(method = RequestMethod.GET, value = "get/by/chapter_id/{chapter_id}")
    public UnifyResponse<List<Comment>> getByChapterId(@PathVariable(name = "chapter_id") Long chapterId) {
        List<Comment> commentList = commentService.getByChapterId(chapterId);
        return new UnifyResponse<>(commentList, "评价查询成功");
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete/by/id/{id}")
    public UnifyResponse delete(@PathVariable Long id) {
        commentService.delete(id);
        return new UnifyResponse("评价删除成功");
    }
}
