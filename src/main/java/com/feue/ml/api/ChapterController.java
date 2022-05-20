package com.feue.ml.api;

import com.feue.ml.dto.ChapterDTO;
import com.feue.ml.entity.Chapter;
import com.feue.ml.service.ChapterService;
import com.feue.ml.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-24 19:50
 */
@RestController
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping(method = RequestMethod.GET, value = "get/by/course_id/{course_id}")
    public UnifyResponse<List<Chapter>> getByCourseId(@PathVariable(name = "course_id") Long courseId) {
        List<Chapter> chapterList = chapterService.getByCourseId(courseId);
        return new UnifyResponse<>(chapterList, "章节查询成功");
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public UnifyResponse add(@RequestBody ChapterDTO dto) {
        chapterService.add(dto);
        return new UnifyResponse("章节添加成功");
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete/by/id/{id}")
    public UnifyResponse delete(@PathVariable Long id) {
        chapterService.delete(id);
        return new UnifyResponse("章节删除成功");
    }
}
