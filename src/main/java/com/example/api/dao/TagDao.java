package com.example.api.dao;

import com.example.api.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDao extends JpaRepository<Tag, Long> {
    boolean existsByTagName(String tagName);
    void deleteByTagName(String tagName);
    Tag findByTagName(String tagName);
}
