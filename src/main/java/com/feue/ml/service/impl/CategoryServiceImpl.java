package com.feue.ml.service.impl;

import com.feue.ml.dto.CategoryDTO;
import com.feue.ml.entity.Category;
import com.feue.ml.repository.CategoryRepository;
import com.feue.ml.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feue
 * @create 2022-04-24 19:46
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void add(CategoryDTO dto) {
        Category category = Category.builder()
                .name(dto.getName())
                .about(dto.getAbout())
                .build();
        categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<String> findAllCategoryNameByIds(List<Long> ids) {
        List<Category> categoryList = new ArrayList<>();
        for (Long id : ids) {
            categoryList.add(categoryRepository.getById(id));
        }
        return categoryList.stream().map(Category::getName).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.getById(id);
        category.setDeleteTime(new Date());
        categoryRepository.save(category);
    }
}
