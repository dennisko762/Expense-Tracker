package com.example.expensetracker.models;

import com.example.expensetracker.models.enums.ExpenseType;
import java.util.UUID;

public class Expense {

    private final UUID id = UUID.randomUUID();
    private UUID userId;
    private double expenseValue;
    private ExpenseType expenseType;


    public UUID getId() {
        return id;
    }

    public double getExpenseValue() {
        return expenseValue;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public UUID getUserId() {
        return userId;
    }
    public void setExpenseValue(double expenseValue) {
        this.expenseValue = expenseValue;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Expense(UUID userId, ExpenseType expenseType, double expenseValue) {
        this.expenseType = expenseType;
        this.expenseValue = expenseValue;
        this.userId = userId;
    }

    public Expense(){}


}
