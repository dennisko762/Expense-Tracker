package com.example.expensetracker.models;

import java.util.UUID;

public class User {

    private Expense[] expenses;
    private final UUID id;

    public User(Expense[] expenses) {
        this.expenses = expenses;
        this.id = UUID.randomUUID();
    }


    private void addExpenses(Expense[] expenses) {

    }


}
