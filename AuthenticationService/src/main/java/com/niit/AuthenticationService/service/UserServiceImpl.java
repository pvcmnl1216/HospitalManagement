/*
 * Author Name: Philip Meshach
 * Date: 18-01-2023
 * Praise The Lord
 */
package com.niit.AuthenticationService.service;

import com.niit.AuthenticationService.domain.User;
import com.niit.AuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        if (userRepository.findById(user.getEmail()).isEmpty()) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User loginCheck(String email, String password) {
        if (userRepository.findById(email).isPresent()) {
            User user = userRepository.findById(email).get();
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(String email) {
        if (userRepository.findById(email).isEmpty()) {
            return "user does not exist";
        }
        userRepository.deleteById(email);
        return "delete successfully";
    }
}
