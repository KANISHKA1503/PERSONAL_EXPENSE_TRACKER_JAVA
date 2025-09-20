import java.time.LocalDate;

public class Expense {
    int id;
    double amount;
    String desc;
    LocalDate date;
    int catId;
    int userId;
    String catName;

    Expense() {
    }

    Expense(double a, String d, String dateStr, int c, int u) {
        amount = a;
        desc = d;
        if (dateStr == null || dateStr.equals("")) {
            date = LocalDate.now();
        } else {
            date = LocalDate.parse(dateStr);
        }
        catId = c;
        userId = u;
    }

    int getId() { return id; }
    void setId(int i) { id = i; }

    double getAmount() { return amount; }
    void setAmount(double a) { amount = a; }

    String getDesc() { return desc; }
    void setDesc(String d) { desc = d; }

    LocalDate getDate() { return date; }
    void setDate(LocalDate dt) { date = dt; }

    int getCatId() { return catId; }
    void setCatId(int c) { catId = c; }

    int getUserId() { return userId; }
    void setUserId(int u) { userId = u; }

    String getCatName() { return catName; }
    void setCatName(String c) { catName = c; }

    public String toString() {
        return id + " | ₹" + amount + " | " + desc + " | " + date + " | " + catName;
    }
}
