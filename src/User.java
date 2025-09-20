public class User {
    int id;
    String uname;
    String pass;
    String email;

    User() {
    }

    User(String u, String p, String e) {
        uname = u;
        pass = p;
        email = e;
    }

    User(int i, String u, String p, String e) {
        id = i;
        uname = u;
        pass = p;
        email = e;
    }

    int getId() {
        return id;
    }

    void setId(int i) {
        id = i;
    }

    String getUname() {
        return uname;
    }

    void setUname(String u) {
        uname = u;
    }

    String getPass() {
        return pass;
    }

    void setPass(String p) {
        pass = p;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String e) {
        email = e;
    }
}
