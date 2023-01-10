package com.example.crud_app.service;

import com.example.crud_app.model.User;
import com.example.crud_app.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(@Valid User user) {
        userRepository.save(user);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void edit(long id, @Valid User user) {
        User userToBeUpdated = userRepository.findById(id).orElse(null);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setAge(user.getAge());
        userToBeUpdated.setEmail(user.getEmail());
        userRepository.save(userToBeUpdated);
    }
}
