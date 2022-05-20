package com.feue.ml.service.impl;

import com.feue.ml.dto.NoticeDTO;
import com.feue.ml.entity.Notice;
import com.feue.ml.repository.NoticeRepository;
import com.feue.ml.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Feue
 * @create 2022-04-25 16:34
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public List<Notice> getAll() {
        return noticeRepository.getByOrderByCreateTimeDesc();
    }

    @Override
    public void add(NoticeDTO dto) {
        Notice notice = Notice.builder()
                .name(dto.getName())
                .content(dto.getContent())
                .userId(dto.getUserId())
                .build();
        noticeRepository.save(notice);
    }

    @Override
    public void delete(Long id) {
        Notice notice = noticeRepository.getById(id);
        notice.setDeleteTime(new Date());
        noticeRepository.save(notice);
    }
}
