package com.feue.ml.api;

import com.feue.ml.dto.VideoDTO;
import com.feue.ml.entity.Video;
import com.feue.ml.service.VideoService;
import com.feue.ml.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Feue
 * @create 2022-04-25 16:53
 */
@RestController
@RequestMapping("video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping(method = RequestMethod.GET, value = "get/by/chapter_id/{chapter_id}")
    public UnifyResponse<List<Video>> getByChapterId(@PathVariable(name = "chapter_id") Long chapterId) {
        List<Video> videoList = videoService.getByChapterId(chapterId);
        return new UnifyResponse<>(videoList, "视频查询成功");
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public UnifyResponse add(@RequestBody VideoDTO dto) {
        videoService.add(dto);
        return new UnifyResponse("视频添加成功");
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete/by/id/{id}")
    public UnifyResponse delete(@PathVariable Long id) {
        videoService.delete(id);
        return new UnifyResponse("视频删除成功");
    }
}
