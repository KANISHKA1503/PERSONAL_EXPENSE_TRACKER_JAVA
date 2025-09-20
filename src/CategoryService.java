import java.util.ArrayList;

public class CategoryService {
    static ArrayList<Category> categories = new ArrayList<Category>();
    static int nextId = 1;

    static {
        categories.add(new Category(nextId++, "Food"));
        categories.add(new Category(nextId++, "Clothing"));
        categories.add(new Category(nextId++, "Cosmetics"));
        categories.add(new Category(nextId++, "Medicine"));
        categories.add(new Category(nextId++, "Stationary"));
        categories.add(new Category(nextId++, "Transport"));
        categories.add(new Category(nextId++, "Entertainment"));
        categories.add(new Category(nextId++, "Bills"));
        categories.add(new Category(nextId++, "Others"));
    }

    static void showAllCategories() {
        System.out.println("Categories:");
        for (Category c : categories) {
            System.out.println(c);
        }
    }

    static String getCategoryName(int id) {
        for (Category c : categories) {
            if (c.getId() == id) {
                return c.getName();
            }
        }
        return "Not Found";
    }

    static void addCategory(String name) {
        categories.add(new Category(nextId++, name));
        System.out.println("Category Added");
    }
}
