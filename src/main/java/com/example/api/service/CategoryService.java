package com.example.api.service;

import com.example.api.dao.CategoryDao;
import com.example.api.exception.InvalidIdException;
import com.example.api.exception.InvalidTitleException;
import com.example.api.exception.IsExistException;
import com.example.api.exception.NotFoundException;
import com.example.api.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryDao categoryDao;

    public boolean save(Category category) {
        if (category.getCategoryName().length() < 2 && category.getCategoryName().isBlank()) {
            throw new InvalidTitleException("Invalid name.", category.getCategoryName(), "save");
        }
        if (categoryDao.existsByCategoryName(category.getCategoryName())) {
            throw new IsExistException("Category is already exist.", category.getCategoryName(), "save");
        } else {
            categoryDao.save(category);
        }
        return true;
    }

    public void deleteById(long id) {
        if (id < 0) {
            throw new InvalidIdException("Invalid id parameter, it can not be a negative value.", id, "deleteById");
        }
        if (categoryDao.existsById(id)) {
            categoryDao.deleteById(id);
        } else {
            throw new NotFoundException("Category is not found", String.valueOf(id), "deleteById");
        }
    }

    public void deleteByName(String name) {
        if (name.length() < 2 && name.isBlank()) {
            throw new InvalidTitleException("Invalid name.", name, "deleteByName");
        }
        if (categoryDao.existsByCategoryName(name)) {
            categoryDao.deleteByCategoryName(name);
        } else {
            throw new NotFoundException("Category is not found.", name, "deleteByName");
        }
    }

    public Category findById(long id) {
        if (id < 0) {
            throw new InvalidIdException("Invalid id parameter, it can not be a negative value.", id, "deleteById");
        }
        if (categoryDao.existsById(id)) {
            return categoryDao.findById(id).get();
        } else {
            throw new NotFoundException("Category is not found.", String.valueOf(id), "findById");
        }
    }

    public Category findByName(String categoryName) {
        if (categoryName.length() < 2 && categoryName.isBlank()) {
            throw new InvalidTitleException("Invalid name.", categoryName, "deleteByName");
        }
        if (categoryDao.existsByCategoryName(categoryName)) {
            return categoryDao.findByCategoryName(categoryName);
        } else {
            throw new NotFoundException("Category is not found.", categoryName, "findByName");
        }
    }

    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}

