package com.feue.ml.repository;

import com.feue.ml.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-25 16:17
 */
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> getByOrderByCreateTimeDesc();
}
