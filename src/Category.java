public class Category {
    int id;
    String name;

    Category() {
    }

    Category(String n) {
        name = n;
    }

    Category(int i, String n) {
        id = i;
        name = n;
    }

    int getId() {
        return id;
    }

    void setId(int i) {
        id = i;
    }

    String getName() {
        return name;
    }

    void setName(String n) {
        name = n;
    }

    public String toString() {
        return id + " - " + name;
    }
}
