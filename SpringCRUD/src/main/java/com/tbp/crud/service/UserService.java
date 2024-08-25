package com.tbp.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbp.crud.dao.UserRepository;
import com.tbp.crud.entity.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users) {
        users.forEach(userRepository::save);
        return users;
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public String deleteUserById(int id) {
        userRepository.deleteById(id);
        return "User got deleted";
    }
}
