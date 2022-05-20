package com.feue.ml.service;

import com.feue.ml.dto.CategoryDTO;
import com.feue.ml.entity.Category;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-24 19:35
 */
public interface CategoryService {
    void add(CategoryDTO dto);

    List<Category> getAll();

    void delete(Long id);
}
