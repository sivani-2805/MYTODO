package com.example.myapplication1;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class TaskDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tasks.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_TASKS = "tasks";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TASK_DETAILS = "task_details";

    public TaskDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_TASKS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TASK_DETAILS + " TEXT NOT NULL);";

        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // If you need to upgrade the database, you can handle it here
    }

    public void insertTask(String taskDetails) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASK_DETAILS, taskDetails);

        db.insert(TABLE_TASKS, null, values);
        db.close();
    }
    public void deleteTask(String taskDetails) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASKS, COLUMN_TASK_DETAILS + "=?", new String[]{taskDetails});
        db.close();
    }


    public ArrayList<String> getAllTasks() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {COLUMN_TASK_DETAILS};
        Cursor cursor = db.query(TABLE_TASKS, projection, null, null, null, null, null);

        int taskDetailsIndex = cursor.getColumnIndex(COLUMN_TASK_DETAILS);

        if (cursor.moveToFirst()) {
            do {
                if (taskDetailsIndex != -1) {
                    String taskDetails = cursor.getString(taskDetailsIndex);
                    taskList.add(taskDetails);
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return taskList;
    }

}

