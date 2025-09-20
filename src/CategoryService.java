import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private static List<Category> categories = new ArrayList<>();
    private static int nextCategoryId = 1;
    
    static {
        categories.add(new Category(nextCategoryId++, "Food"));
        categories.add(new Category(nextCategoryId++, "Clothing"));
        categories.add(new Category(nextCategoryId++, "Cosmetics"));
        categories.add(new Category(nextCategoryId++, "Medicine"));
        categories.add(new Category(nextCategoryId++, "Stationary"));
        categories.add(new Category(nextCategoryId++, "Transport"));
        categories.add(new Category(nextCategoryId++, "Entertainment"));
        categories.add(new Category(nextCategoryId++, "Bills"));
        categories.add(new Category(nextCategoryId++, "Others"));
    }
    
    public static void showAllCategories() {
        System.out.println("Available Categories:");
        for (Category category : categories) {
            System.out.println(category);
        }
    }
    
    public static String getCategoryName(int categoryId) {
        for (Category category : categories) {
            if (category.getId() == categoryId) {
                return category.getName();
            }
        }
        return "Unknown";
    }
    
    public static boolean addCategory(String name) {
        try {
            categories.add(new Category(nextCategoryId++, name));
            System.out.println("Category added successfully!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}