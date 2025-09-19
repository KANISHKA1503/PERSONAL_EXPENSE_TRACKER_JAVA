// src/services/UserService.java
package services;
import models.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<User> users = new ArrayList<>();
    private static int nextUserId = 1;
    
    // Add some default users for testing
    static {
        users.add(new User(nextUserId++, "admin", "admin123", "admin@test.com"));
        users.add(new User(nextUserId++, "user", "user123", "user@test.com"));
    }
    
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    
    public boolean register(String username, String password, String email) {
        // Check if username already exists
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        
        User newUser = new User(nextUserId++, username, password, email);
        users.add(newUser);
        return true;
    }
    
    public boolean isValidUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
}