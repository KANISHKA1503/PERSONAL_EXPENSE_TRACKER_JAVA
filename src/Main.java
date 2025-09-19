// src/Main.java
import java.util.Scanner;
import models.User;
import models.Expense;
import services.UserService;
import services.ExpenseService;
import services.CategoryService;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserService();
    private static ExpenseService expenseService = new ExpenseService();
    private static User currentUser = null;
    
    public static void main(String[] args) {
        System.out.println("=== PERSONAL EXPENSE TRACKER ===");
        
        while (true) {
            if (currentUser == null) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }
    
    private static void showLoginMenu() {
        System.out.println("\n--- LOGIN MENU ---");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.out.println("Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        currentUser = userService.login(username, password);
        if (currentUser != null) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
    
    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        if (userService.register(username, password, email)) {
            System.out.println("Registration successful! Please login.");
        } else {
            System.out.println("Registration failed!");
        }
    }
    
    private static void showMainMenu() {
        System.out.println("\n=== Welcome " + currentUser.getUsername() + "! ===");
        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. View by Category");
        System.out.println("4. Delete Expense");
        System.out.println("5. Logout");
        System.out.print("Enter choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                addExpense();
                break;
            case 2:
                expenseService.viewAllExpenses(currentUser.getId());
                break;
            case 3:
                viewByCategory();
                break;
            case 4:
                deleteExpense();
                break;
            case 5:
                currentUser = null;
                System.out.println("Logged out!");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void addExpense() {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        
        System.out.print("Enter date (YYYY-MM-DD) or press Enter for today: ");
        String dateStr = scanner.nextLine();
        
        CategoryService.showAllCategories();
        System.out.print("Enter category ID: ");
        int categoryId = scanner.nextInt();
        
        Expense expense = new Expense(amount, description, dateStr, categoryId, currentUser.getId());
        
        if (expenseService.addExpense(expense)) {
            System.out.println("Expense added successfully!");
        } else {
            System.out.println("Failed to add expense!");
        }
    }
    
    private static void viewByCategory() {
        CategoryService.showAllCategories();
        System.out.print("Enter category ID: ");
        int categoryId = scanner.nextInt();
        
        expenseService.viewExpensesByCategory(currentUser.getId(), categoryId);
    }
    
    private static void deleteExpense() {
        expenseService.viewAllExpenses(currentUser.getId());
        System.out.print("Enter expense ID to delete: ");
        int expenseId = scanner.nextInt();
        
        if (expenseService.deleteExpense(expenseId, currentUser.getId())) {
            System.out.println("Expense deleted!");
        } else {
            System.out.println("Failed to delete!");
        }
    }
}