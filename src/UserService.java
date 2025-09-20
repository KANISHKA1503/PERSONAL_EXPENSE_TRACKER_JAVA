import java.util.ArrayList;

public class UserService {
    static ArrayList<User> users = new ArrayList<User>();
    static int nextId = 1;

    static {
        users.add(new User(nextId++, "admin", "admin123", "admin@gmail.com"));
        users.add(new User(nextId++, "user", "user123", "user@gmail.com"));
    }

    User login(String u, String p) {
        for (User x : users) {
            if (x.getUsername().equals(u) && x.getPassword().equals(p)) {
                return x;
            }
        }
        return null;
    }

    boolean register(String u, String p, String e) {
        for (User x : users) {
            if (x.getUsername().equals(u)) {
                return false;
            }
        }
        users.add(new User(nextId++, u, p, e));
        return true;
    }
}
