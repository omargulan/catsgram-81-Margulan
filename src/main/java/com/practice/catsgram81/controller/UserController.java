package com.practice.catsgram81.controller;

import com.practice.catsgram81.model.User;
import com.practice.catsgram81.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public Collection<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/users")
    public User create(@RequestBody User user){

        return userService.create(user);
    }

    @PutMapping("/users")
    public User update(@RequestBody User user){
        return userService.update( user);
    }

    @GetMapping("/users/{email}")
    public User findUserByEmail(@PathVariable String email){
        return  userService.findUserByEmail(email);
    }
}
