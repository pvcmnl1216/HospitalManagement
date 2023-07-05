/*
 * Author Name: Philip Meshach
 * Date: 18-01-2023
 * Praise The Lord
 */
package com.niit.AuthenticationService.controller;

import com.niit.AuthenticationService.domain.User;
import com.niit.AuthenticationService.service.GenerateTokenImpl;
import com.niit.AuthenticationService.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class UserController {

    UserServiceImpl userService;
    GenerateTokenImpl token;
    @Autowired
    public UserController(UserServiceImpl userService, GenerateTokenImpl token) {
        this.userService = userService;
        this.token = token;
    }

    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody User user){
        return new ResponseEntity<>( userService.addUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?>loginCheck(@RequestBody User user){
        User user1 = userService.loginCheck(user.getEmail(),user.getPassword());
        if(user1!=null){
            Map<String ,String > map = token.generateToken(user1);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User Not Exist",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?>get(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }
    @DeleteMapping("/user/{email}")
    public ResponseEntity<?>delete(@PathVariable String email){
        return new ResponseEntity<>(userService.deleteUser(email),HttpStatus.OK);
    }
}
