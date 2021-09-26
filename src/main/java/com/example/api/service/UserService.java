package com.example.api.service;

import com.example.api.dao.UserDao;
import com.example.api.exception.InvalidIdException;
import com.example.api.exception.InvalidTitleException;
import com.example.api.exception.NotFoundException;
import com.example.api.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDao userDao;

    public boolean save(User user) {
        if (user.getName().length() < 2 && user.getName().isBlank()) {
            throw new InvalidTitleException("Invalid name.", user.getName(), "save");
        }
        if (userDao.existsByName(user.getName())) {
            throw new NotFoundException("User is not found.", user.getName(), "save");
        } else {
            userDao.save(user);
        }
        return true;
    }

    public void deleteById(long id) {
        if (id < 0) {
            throw new InvalidIdException("Invalid id parameter, it can not be a negative value.", id, "deleteById");
        }
        if (userDao.existsById(id)) {
            userDao.deleteById(id);
        } else {
            throw new NotFoundException("User is not found.", String.valueOf(id), "deleteById");
        }
    }

    public void deleteByName(String name) {
        if (name.length() < 2 && name.isBlank()) {
            throw new InvalidTitleException("Invalid name.", name, "deleteByName");
        }
        if (userDao.existsByName(name)) {
            userDao.deleteByName(name);
        } else {
            throw new NotFoundException("User is not found.", name, "deleteByName");
        }
    }

    public User findById(long id) {
        if (id < 0) {
            throw new InvalidIdException("Invalid id parameter, it can not be a negative value.", id, "findById");
        }
        if (userDao.existsById(id)) {
            return userDao.findById(id).get();
        } else {
            throw new NotFoundException("User is not found.", String.valueOf(id), "findById");
        }
    }

    public User findByName(String name) {
        if (name.length() < 2 && name.isBlank()) {
            throw new InvalidTitleException("Invalid name.", name, "findByName");
        }
        if (userDao.existsByName(name)) {
            return userDao.findByName(name);
        } else {
            throw new NotFoundException("User is not found.", name, "findByName");
        }
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

}
