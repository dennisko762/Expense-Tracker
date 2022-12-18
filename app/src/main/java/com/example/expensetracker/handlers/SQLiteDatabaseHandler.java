package com.example.expensetracker.handlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.expensetracker.models.Expense;
import com.example.expensetracker.models.enums.ExpenseType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "expenseTracker";

    private static final String TABLE_EXPENSES= "Expenses";
    private static final String TABLE_USERS= "Users";


    // User Table Columns
    private static final String KEY_USER_ID = "id";
    private static final String EXPENSES = "Expenses";

    // Expenses Table Columns
    private static final String EXPENSE_VALUE = "ExpenseValue";
    private static final String KEY_EXPENSE_ID = "id";
    private static final String EXPENSE_TYPE = "ExpenseType";
    private static final String USER_ID = "UserId";


    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_USER_ID + " INTEGER PRIMARY KEY," + EXPENSES + " TABLE_EXPENSES" + ")";

        String CREATE_EXPENSES_TABLE = "CREATE TABLE " + TABLE_EXPENSES + "("
                + KEY_EXPENSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + EXPENSE_VALUE + " INTEGER," + EXPENSE_TYPE + " STRING," + USER_ID + " INTEGER"   + ")";

        sqLiteDatabase.execSQL(CREATE_USERS_TABLE);
        sqLiteDatabase.execSQL(CREATE_EXPENSES_TABLE);

    }

    public ArrayList<Expense> getAllExpenses(  ) {
        ArrayList<Expense> expenses = new ArrayList();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EXPENSES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
               expenses.add(new Expense(UUID.fromString(cursor.getString(3)), ExpenseType.valueOf(cursor.getString(2)), Double.parseDouble(cursor.getString(1))));
            } while (cursor.moveToNext());
        }


        // return country list
        cursor.close();
        return expenses;
    }

    public void addExpense(Expense expense){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EXPENSE_VALUE, expense.getExpenseValue());
        values.put(EXPENSE_TYPE, String.valueOf(expense.getExpenseType()));
        values.put(USER_ID, String.valueOf(expense.getUserId()));

        db.insert(TABLE_EXPENSES, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSES);
        onCreate(db);
    }
}
