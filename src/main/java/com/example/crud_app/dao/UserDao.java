package com.example.crud_app.dao;

import com.example.crud_app.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User save(User user);

    void deleteById(long id);

    User edit(long id, User user);

    User getById(long id);

}
