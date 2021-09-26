package com.example.api.controller;

import com.example.api.model.Category;
import com.example.api.model.Post;
import com.example.api.model.Tag;
import com.example.api.model.User;
import com.example.api.service.CategoryService;
import com.example.api.service.PostService;
import com.example.api.service.TagService;
import com.example.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
@Transactional
public class PostController {

    private final PostService postService;
    private final CategoryService categoryService;
    private final TagService tagService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Post post) {
        postService.save(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        postService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/byName")
    public ResponseEntity<?> deleteByName(@RequestParam String title) {
        postService.deleteByTitle(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        Post post = postService.findById(id);
        return new ResponseEntity<>(post, HttpStatus.FOUND);
    }

    @GetMapping("/byName")
    public ResponseEntity<?> findByTitle(@RequestParam String title) {
        Post post = postService.findByTitle(title);
        return new ResponseEntity<>(post, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Post> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.FOUND);
    }

    @GetMapping("/byCategory/{id}")
    public ResponseEntity<?> findAllByCategory(@PathVariable long id) {
        Category category = categoryService.findById(id);
        List<Post> posts = postService.findAllByCategory(category);
        return new ResponseEntity<>(posts, HttpStatus.FOUND);
    }

    @GetMapping("/byTag/{id}")
    public ResponseEntity<?> findAllByTag(@PathVariable long id) {
        Tag tag = tagService.findById(id);
        List<Post> posts = postService.findAllByTag(tag);
        return new ResponseEntity<>(posts, HttpStatus.FOUND);
    }

    @GetMapping("/byUser/{id}")
    public ResponseEntity<?> findAllByUser(@PathVariable long id) {
        User user = userService.findById(id);
        List<Post> posts = postService.findAllByUser(user);
        return new ResponseEntity<>(posts, HttpStatus.FOUND);
    }



}


