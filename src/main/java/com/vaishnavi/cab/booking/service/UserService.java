package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.repository.UserRepository;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserRepository userRepository;

    // Setter for dependency injection
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) throws SQLException {
        if (user.getName() != null && !user.getName().isEmpty()) {
            userRepository.addUser(user);
        } else {
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
    }

    public List<User> retrieveAllUsers() throws SQLException {
        return userRepository.getAllUsers();
    }

    // Additional business logic methods
}





