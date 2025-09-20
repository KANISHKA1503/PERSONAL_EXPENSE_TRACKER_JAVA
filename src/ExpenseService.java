import java.util.ArrayList;

public class ExpenseService {
    static ArrayList<Expense> expenses = new ArrayList<Expense>();
    static int nextId = 1;

    boolean addExpense(Expense e) {
        e.setId(nextId++);
        expenses.add(e);
        return true;
    }

    void viewAllExpenses(int userId) {
        ArrayList<Expense> list = new ArrayList<Expense>();
        for (Expense ex : expenses) {
            if (ex.getUserId() == userId) {
                list.add(ex);
            }
        }

        if (list.size() == 0) {
            System.out.println("No expenses");
            return;
        }

        System.out.println("Your Expenses:");
        double total = 0;
        for (Expense ex : list) {
            ex.setCatName(CategoryService.getCategoryName(ex.getCatId()));
            System.out.println(ex);
            total += ex.getAmount();
        }
        System.out.println("Total = ₹" + total);
    }

    void viewExpensesByCategory(int userId, int catId) {
        ArrayList<Expense> list = new ArrayList<Expense>();
        for (Expense ex : expenses) {
            if (ex.getUserId() == userId && ex.getCatId() == catId) {
                list.add(ex);
            }
        }

        if (list.size() == 0) {
            System.out.println("No expenses in this category");
            return;
        }

        String catName = CategoryService.getCategoryName(catId);
        System.out.println("Category: " + catName);
        double total = 0;
        for (Expense ex : list) {
            ex.setCatName(catName);
            System.out.println(ex);
            total += ex.getAmount();
        }
        System.out.println("Total = ₹" + total);
    }

    boolean deleteExpense(int exId, int userId) {
        for (int i = 0; i < expenses.size(); i++) {
            Expense ex = expenses.get(i);
            if (ex.getId() == exId && ex.getUserId() == userId) {
                expenses.remove(i);
                return true;
            }
        }
        return false;
    }

    ArrayList<Expense> getUserExpenses(int userId) {
        ArrayList<Expense> list = new ArrayList<Expense>();
        for (Expense ex : expenses) {
            if (ex.getUserId() == userId) {
                list.add(ex);
            }
        }
        return list;
    }
}
