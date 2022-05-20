package com.feue.ml.service;

import com.feue.ml.dto.NoticeDTO;
import com.feue.ml.entity.Notice;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-25 16:18
 */
public interface NoticeService {
    List<Notice> getAll();

    void add(NoticeDTO dto);

    void delete(Long id);
}
