package com.example.crud_app.service;

import com.example.crud_app.dao.UserDao;
import com.example.crud_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    @Transactional
    @Override
    public User edit(long id, User user) {
        return userDao.edit(id, user);
    }

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }
}
