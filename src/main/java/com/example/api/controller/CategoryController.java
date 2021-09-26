package com.example.api.controller;

import com.example.api.model.Category;
import com.example.api.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/categories")
@Transactional
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/byName")
    public ResponseEntity<?> deleteByName(@RequestParam String name) {
        categoryService.deleteByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        Category category = categoryService.findById(id);
        return new ResponseEntity<>(category, HttpStatus.FOUND);
    }

    @GetMapping("/byName")
    public ResponseEntity<?> findByName(@RequestParam String name) {
        Category category = categoryService.findByName(name);
        return new ResponseEntity<>(category, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.FOUND);
    }


}
