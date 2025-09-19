// src/services/ExpenseService.java
package services;
import models.Expense;
import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private static List<Expense> expenses = new ArrayList<>();
    private static int nextExpenseId = 1;
    
    public boolean addExpense(Expense expense) {
        try {
            expense.setId(nextExpenseId++);
            expenses.add(expense);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void viewAllExpenses(int userId) {
        List<Expense> userExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getUserId() == userId) {
                userExpenses.add(expense);
            }
        }
        
        if (userExpenses.isEmpty()) {
            System.out.println("No expenses found!");
            return;
        }
        
        System.out.println("Your Expenses:");
        System.out.println("===============================================");
        double total = 0.0;
        for (Expense expense : userExpenses) {
            expense.setCategoryName(CategoryService.getCategoryName(expense.getCategoryId()));
            System.out.println(expense);
            total += expense.getAmount();
        }
        System.out.println("===============================================");
        System.out.printf("Total Amount: $%.2f%n", total);
    }
    
    public void viewExpensesByCategory(int userId, int categoryId) {
        List<Expense> categoryExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getUserId() == userId && expense.getCategoryId() == categoryId) {
                categoryExpenses.add(expense);
            }
        }
        
        if (categoryExpenses.isEmpty()) {
            System.out.println("No expenses found for this category!");
            return;
        }
        
        String categoryName = CategoryService.getCategoryName(categoryId);
        System.out.println("Expenses for Category: " + categoryName);
        System.out.println("===============================================");
        double total = 0.0;
        for (Expense expense : categoryExpenses) {
            expense.setCategoryName(categoryName);
            System.out.println(expense);
            total += expense.getAmount();
        }
        System.out.println("===============================================");
        System.out.printf("Total Amount: $%.2f%n", total);
    }
    
    public boolean deleteExpense(int expenseId, int userId) {
        for (int i = 0; i < expenses.size(); i++) {
            Expense expense = expenses.get(i);
            if (expense.getId() == expenseId && expense.getUserId() == userId) {
                expenses.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public List<Expense> getUserExpenses(int userId) {
        List<Expense> userExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getUserId() == userId) {
                userExpenses.add(expense);
            }
        }
        return userExpenses;
    }
}