import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static UserService userService = new UserService();
    static ExpenseService expenseService = new ExpenseService();
    static User current = null;

    public static void main(String[] args) {
        System.out.println("== Expense Tracker ==");

        while (true) {
            if (current == null) {
                loginMenu();
            } else {
                mainMenu();
            }
        }
    }

    static void loginMenu() {
        System.out.println("\n1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            login();
        } else if (choice == 2) {
            register();
        } else if (choice == 3) {
            System.out.println("Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Wrong choice!");
        }
    }

    static void login() {
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        current = userService.login(user, pass);

        if (current != null) {
            System.out.println("Hello " + current.getUsername());
        } else {
            System.out.println("Invalid login");
        }
    }

    static void register() {
        System.out.print("New Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        System.out.print("Email: ");
        String mail = sc.nextLine();

        boolean done = userService.register(user, pass, mail);

        if (done) {
            System.out.println("Registered. Please login.");
        } else {
            System.out.println("Username exists.");
        }
    }

    static void mainMenu() {
        System.out.println("\nWelcome " + current.getUsername());
        System.out.println("1. Add Expense");
        System.out.println("2. View All");
        System.out.println("3. View By Category");
        System.out.println("4. Delete");
        System.out.println("5. Logout");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            addExpense();
        } else if (choice == 2) {
            expenseService.viewAllExpenses(current.getId());
        } else if (choice == 3) {
            viewByCategory();
        } else if (choice == 4) {
            deleteExpense();
        } else if (choice == 5) {
            current = null;
            System.out.println("Logged out");
        } else {
            System.out.println("Wrong choice!");
        }
    }

    static void addExpense() {
        System.out.print("Amount ₹: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        System.out.print("Note: ");
        String desc = sc.nextLine();

        System.out.print("Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.println("Categories:");
        CategoryService.showAllCategories();
        System.out.print("Enter category id: ");
        int cid = sc.nextInt();

        Expense exp = new Expense(amt, desc, date, cid, current.getId());
        boolean ok = expenseService.addExpense(exp);

        if (ok) {
            System.out.println("Added");
        } else {
            System.out.println("Not added");
        }
    }

    static void viewByCategory() {
        System.out.println("Categories:");
        CategoryService.showAllCategories();
        System.out.print("Enter category id: ");
        int cid = sc.nextInt();

        expenseService.viewExpensesByCategory(current.getId(), cid);
    }

    static void deleteExpense() {
        System.out.println("Your expenses:");
        expenseService.viewAllExpenses(current.getId());
        System.out.print("Enter expense id to delete: ");
        int id = sc.nextInt();

        boolean ok = expenseService.deleteExpense(id, current.getId());
        if (ok) {
            System.out.println("Deleted");
        } else {
            System.out.println("Not deleted");
        }
    }
}
