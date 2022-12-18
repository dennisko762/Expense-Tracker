package com.example.expensetracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.expensetracker.R;
import com.example.expensetracker.models.Expense;
import com.example.expensetracker.models.enums.ExpenseType;
import java.util.ArrayList;
import java.util.Currency;

public class ExpensesListAdapter extends ArrayAdapter<Expense> {
    private Context context;
    int resource;

    public ExpensesListAdapter( Context context, int resource, ArrayList<Expense> expenseList) {
        super(context, resource, expenseList);
        this.context = context;
        this.resource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ExpenseType expenseType = getItem(position).getExpenseType();
        double expenseValue = getItem(position).getExpenseValue();

        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(this.resource, parent, false);

        TextView textViewExpenseType = convertView.findViewById(R.id.expenseType);
        TextView textViewExpenseValue = convertView.findViewById(R.id.expenseValue);

        textViewExpenseType.setText(expenseType.toString());
        textViewExpenseValue.setText(String.valueOf( expenseValue) + Currency.getInstance("EUR").getSymbol());

        return convertView;
    }
}
