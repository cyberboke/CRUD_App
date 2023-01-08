package com.example.crud_app.dao;

import com.example.crud_app.model.User;
import com.example.crud_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User edit(long id, User user) {
        User userToBeUpdated = userRepository.findById(id).orElse(null);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setAge(user.getAge());
        userToBeUpdated.setEmail(user.getEmail());
        return userRepository.save(userToBeUpdated);
    }
}
