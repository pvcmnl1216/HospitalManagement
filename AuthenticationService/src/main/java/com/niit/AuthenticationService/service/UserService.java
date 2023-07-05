package com.niit.AuthenticationService.service;

import com.niit.AuthenticationService.domain.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User loginCheck(String email, String password);

    List<User> getAll();

    String deleteUser(String email);


}
