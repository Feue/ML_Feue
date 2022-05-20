package com.feue.ml.api;

import com.feue.ml.dto.NoticeDTO;
import com.feue.ml.entity.Notice;
import com.feue.ml.service.NoticeService;
import com.feue.ml.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-25 16:25
 */
@RestController
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(method = RequestMethod.GET, value = "all")
    public UnifyResponse<List<Notice>> getAll() {
        List<Notice> noticeList = noticeService.getAll();
        return new UnifyResponse<>(noticeList, "公告查询成功");
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public UnifyResponse add(@RequestBody NoticeDTO dto) {
        noticeService.add(dto);
        return new UnifyResponse("公告发布成功");
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete/by/id/{id}")
    public UnifyResponse delete(@PathVariable Long id) {
        noticeService.delete(id);
        return new UnifyResponse("公告删除成功");
    }
}
