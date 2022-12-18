package com.example.expensetracker.main;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.expensetracker.R;
import com.example.expensetracker.adapters.ExpensesListAdapter;
import com.example.expensetracker.handlers.SQLiteDatabaseHandler;
import com.example.expensetracker.models.Expense;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabaseHandler db;
    ArrayList<Expense> expenses;
    ListView expensesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_main);

        db= new SQLiteDatabaseHandler(this);
        expenses = db.getAllExpenses();
        expensesListView = findViewById(R.id.expensesListView);

        ExpensesListAdapter expenseArrayAdapter = new ExpensesListAdapter(this, R.layout.list_view_item_layout, expenses);
        expensesListView.setAdapter(expenseArrayAdapter);
    }
}
