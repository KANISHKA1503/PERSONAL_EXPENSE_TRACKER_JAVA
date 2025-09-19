// src/models/Expense.java
package models;
import java.time.LocalDate;

public class Expense {
    private int id;
    private double amount;
    private String description;
    private LocalDate date;
    private int categoryId;
    private int userId;
    private String categoryName;
    
    public Expense() {
    }
    
    public Expense(double amount, String description, String dateStr, int categoryId, int userId) {
        this.amount = amount;
        this.description = description;
        if (dateStr == null || dateStr.isEmpty()) {
            this.date = LocalDate.now();
        } else {
            this.date = LocalDate.parse(dateStr);
        }
        this.categoryId = categoryId;
        this.userId = userId;
    }
    
    // Getters
    public int getId() { return id; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public LocalDate getDate() { return date; }
    public int getCategoryId() { return categoryId; }
    public int getUserId() { return userId; }
    public String getCategoryName() { return categoryName; }
    
    // Setters
    public void setId(int id) { this.id = id; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setDescription(String description) { this.description = description; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    
    public String toString() {
        return String.format("ID: %d | Amount: $%.2f | %s | Date: %s | Category: %s", 
                           id, amount, description, date, categoryName);
    }
}