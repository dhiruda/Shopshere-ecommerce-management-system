package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.User;
import com.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user) {

    	return userService.loginUser(
    			user.getEmail(),
    			user.getPassword()
    	);
    }
    
    
    // Save single user
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Save multiple users
    @PostMapping("/saveAll")
    public List<User> saveAllUsers(@RequestBody List<User> users) {
        return userService.saveAll(users);
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by id
    @GetMapping("/{eid}")
    public Optional<User> getUserById(@PathVariable int eid) {
        return userService.getUserById(eid);
    }

    // Update user
    @PutMapping("/update/{eid}")
    public User updateUser(@PathVariable int eid, @RequestBody User user) {
        return userService.updateUser(eid, user);
    }

    // Delete user
    @DeleteMapping("/delete/{eid}")
    public String deleteUser(@PathVariable int eid) {
        userService.deleteUser(eid);
        return "User Deleted Successfully";
    }
}