package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;
import java.sql.SQLException;
import java.util.List;

public class UserController {
    private UserService userService;

    // Setter for dependency injection
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void createUser(User user) {
        try {
            userService.registerUser(user);
            System.out.println("User registered successfully.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error registering user: " + e.getMessage());
        }
    }

    public void listAllUsers() {
        try {
            List<User> users = userService.retrieveAllUsers();
            users.forEach(u -> System.out.println(u.getUserId() + " | " + u.getName() + " | " + u.getEmail()));
        } catch (SQLException e) {
            System.err.println("Error retrieving users: " + e.getMessage());
        }
    }

    // Additional controller methods
}



