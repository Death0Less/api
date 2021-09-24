package com.example.api.service;

import com.example.api.dao.TagDao;
import com.example.api.exception.NotFoundException;
import com.example.api.model.Tag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagService {

    private final TagDao tagDao;

    public boolean save(Tag tag) {
        if (tagDao.existsByTagName(tag.getTagName())) {
            throw new NotFoundException("Tag is not found.", tag.getTagName(), "save");
        } else {
            tagDao.save(tag);
        }
        return true;
    }

    public void deleteById(long id) {
        if (tagDao.existsById(id)) {
            tagDao.deleteById(id);
        } else {
            throw new NotFoundException("Tag is not found.", String.valueOf(id), "deleteById");
        }
    }

    public void deleteByName(String tagName) {
        if (tagDao.existsByTagName(tagName)) {
            tagDao.deleteByTagName(tagName);
        } else {
            throw new NotFoundException("Tag is not found.", tagName, "deleteByName");
        }
    }

    public Tag findById(long id) {
        if (tagDao.existsById(id)) {
            return tagDao.findById(id).get();
        } else {
            throw new NotFoundException("Tag is not found.", String.valueOf(id), "findById");
        }
    }

    public Tag findByName(String tagName) {
        if (tagDao.existsByTagName(tagName)) {
            return tagDao.findByTagName(tagName);
        } else {
            throw new NotFoundException("Tag is not found.", tagName, "findByName");
        }
    }

    public List<Tag> findAll() {
        return tagDao.findAll();
    }
}
