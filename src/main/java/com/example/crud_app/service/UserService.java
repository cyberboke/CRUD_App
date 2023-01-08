package com.example.crud_app.service;

import com.example.crud_app.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User save(User user);

    void deleteById(long id);

    User edit(long id, User user);

    User getById(long id);
}
