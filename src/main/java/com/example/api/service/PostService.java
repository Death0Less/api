package com.example.api.service;

import com.example.api.dao.PostDao;
import com.example.api.exception.NotFoundException;
import com.example.api.model.Category;
import com.example.api.model.Post;
import com.example.api.model.Tag;
import com.example.api.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostDao postDao;

    public void save(Post post) {
        if (postDao.existsByTitle(post.getTitle())) {
            throw new NotFoundException("Post is not found.", post.getTitle(), "save");
        } else {
            postDao.save(post);
        }
    }

    public void deleteById(long id) {
        if (postDao.existsById(id)) {
            postDao.deleteById(id);
        } else {
            throw new NotFoundException("Post is not found.", String.valueOf(id), "deleteById");
        }
    }

    public void deleteByName(String tagName) {
        if (postDao.existsByTitle(tagName)) {
            postDao.deleteByTitle(tagName);
        } else {
            throw new NotFoundException("Post is not found", tagName, "deleteByName");
        }
    }

    public Post findById(long id) {
        if (postDao.existsById(id)) {
            return postDao.findById(id).get();
        } else {
            throw new NotFoundException("Post is not found", String.valueOf(id), "findById");
        }
    }

    public Post findByName(String tagName) {
        if (postDao.existsByTitle(tagName)) {
            return postDao.findByTitle(tagName);
        } else {
            throw new NotFoundException("Post is not found", tagName, "findByName");
        }
    }

    public List<Post> findAll() {
        return postDao.findAll();
    }

    public List<Post> findAllByCategory(Category category) {
        return postDao.findAllByCategory(category);
    }

    public List<Post> findAllByTag(Tag tag) {
        return postDao.findAllByTag(tag);
    }

    public List<Post> findAllByUser(User user) {
        return postDao.findAllByUser(user);
    }
}
