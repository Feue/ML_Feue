package com.feue.ml.repository;

import com.feue.ml.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Feue
 * @create 2022-04-24 19:33
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
