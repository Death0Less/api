package com.example.api.dao;

import com.example.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {
    boolean existsByCategoryName(String categoryName);
    void deleteByCategoryName (String categoryName);
    Category findByCategoryName(String categoryName);
}
