import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<User> users = new ArrayList<>();
    private static int nextUserId = 1;
    
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
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        User newUser = new User(nextUserId++, username, password, email);
        users.add(newUser);
        return true;
    }
}