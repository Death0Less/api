package com.example.api.service;

import com.example.api.dao.CategoryDao;
import com.example.api.exception.IsExistException;
import com.example.api.exception.NotFoundException;
import com.example.api.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryDao categoryDao;

    public boolean save(Category category) {
        if (categoryDao.existsCategoryName(category.getCategoryName())) {
            throw new IsExistException("Category is already exist.", category.getCategoryName(), "save");
        } else {
            categoryDao.save(category);
        }
        return true;
    }

    public void deleteById(long id) {
        if (categoryDao.existsById(id)) {
            categoryDao.deleteById(id);
        } else {
            throw new NotFoundException("Category is not foind", String.valueOf(id), "deleteById");
        }
    }

    public void deleteByName(String name) {
        if (categoryDao.existsCategoryName(name)) {
            categoryDao.deleteByCategoryName(name);
        } else {
            throw new NotFoundException("Category is not found.", name, "deleteByName");
        }
    }
}

