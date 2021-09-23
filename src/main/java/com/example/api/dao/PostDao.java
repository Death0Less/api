package com.example.api.dao;

import com.example.api.model.Category;
import com.example.api.model.Post;
import com.example.api.model.Tag;
import com.example.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostDao extends JpaRepository<Post, Long> {
    boolean existsByTitle(String title);
    Post findByTitle(String title);
    void deleteByTitle(String title);
    List<Post> findAllByCategory(Category category);
    List<Tag> findAllByTag(Tag tag);
    List<User> findAllByUser(User user);
}
