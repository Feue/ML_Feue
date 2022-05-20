package com.feue.ml.api;

import com.feue.ml.dto.CategoryDTO;
import com.feue.ml.entity.Category;
import com.feue.ml.service.CategoryService;
import com.feue.ml.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-24 19:35
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, value = "get/all")
    public UnifyResponse<List<Category>> getAll() {
        List<Category> categoryList = categoryService.getAll();
        return new UnifyResponse<>(categoryList, "查询成功");
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public UnifyResponse add(@RequestBody CategoryDTO dto) {
        categoryService.add(dto);
        return new UnifyResponse("添加成功");
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete/by/id/{id}")
    public UnifyResponse delete(@PathVariable Long id) {
        categoryService.delete(id);
        return new UnifyResponse("删除成功");
    }
}
