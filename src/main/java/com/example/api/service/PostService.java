package com.example.api.service;

import com.example.api.dao.PostDao;
import com.example.api.exception.InvalidIdException;
import com.example.api.exception.InvalidTitleException;
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

    public boolean save(Post post) {
        if (post.getTitle().length() < 2 && post.getTitle().isBlank()) {
            throw new InvalidTitleException("Invalid tagName.", post.getTitle(), "save");
        }
        if (postDao.existsByTitle(post.getTitle())) {
            throw new NotFoundException("Post is not found.", post.getTitle(), "save");
        } else {
            postDao.save(post);
        }
        return true;
    }

    public void deleteById(long id) {
        if (id < 0) {
            throw new InvalidIdException("Invalid id parameter, it can not be a negative value.",id, "deleteById" );
        }
        if (postDao.existsById(id)) {
            postDao.deleteById(id);
        } else {
            throw new NotFoundException("Post is not found.", String.valueOf(id), "deleteById");
        }
    }

    public void deleteByTitle(String title) {
        if (title.length() < 2 && title.isBlank()) {
            throw new InvalidTitleException("Invalid tagName.", title, "deleteByName");
        }
        if (postDao.existsByTitle(title)) {
            postDao.deleteByTitle(title);
        } else {
            throw new NotFoundException("Post is not found.", title, "deleteByName");
        }
    }

    public Post findById(long id) {
        if (id < 0) {
            throw new InvalidIdException("Invalid id parameter, it can not be a negative value.", id, "findById");
        }
        if (postDao.existsById(id)) {
            return postDao.findById(id).get();
        } else {
            throw new NotFoundException("Post is not found,", String.valueOf(id), "findById");
        }
    }

    public Post findByTitle(String title) {
        if (title.length() < 2 && title.isBlank()) {
           throw new InvalidTitleException("Invalid tagName.", title, "findByName");
        }
        if (postDao.existsByTitle(title)) {
            return postDao.findByTitle(title);
        } else {
            throw new NotFoundException("Post is not found.", title, "findByName");
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
