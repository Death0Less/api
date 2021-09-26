package com.example.api.controller;

import com.example.api.model.Tag;
import com.example.api.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tags")
@Transactional
public class TagController {

    private final TagService tagService;

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Tag tag) {
        tagService.save(tag);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        tagService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/byName")
    public ResponseEntity<?> deleteByName(@RequestParam String tagName) {
        tagService.deleteByName(tagName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        Tag tag = tagService.findById(id);
        return new ResponseEntity<>(tag, HttpStatus.FOUND);
    }

    @GetMapping("/byName")
    public ResponseEntity<?> findByName(@RequestParam String tagName) {
        Tag tag = tagService.findByName(tagName);
        return new ResponseEntity<>(tag,HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Tag> tags = tagService.findAll();
        return new ResponseEntity<>(tags, HttpStatus.FOUND);
    }
}
