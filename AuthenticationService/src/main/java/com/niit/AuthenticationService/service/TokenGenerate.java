package com.niit.AuthenticationService.service;

import com.niit.AuthenticationService.domain.User;

import java.util.Map;

public interface TokenGenerate {
    public Map<String,String> generateToken(User user);
}
