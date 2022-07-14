package com.jikjii.usermgmtsystem.controller;

import com.jikjii.usermgmtsystem.model.User;
import com.jikjii.usermgmtsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    // handling services

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Handles saving user service

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Handles fetching all users from DB

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Handles fetching one user in db by ID

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = null;
        user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // Handles deleting service by ID

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable("id") Long id) {
        boolean deleted = false;
        deleted = userService.deleteUser(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);

    }

    // Handles edit service by ID

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,
                                           @RequestBody User user) {
        user = userService.updateUser(id,user);

        return ResponseEntity.ok(user);
    }

}
