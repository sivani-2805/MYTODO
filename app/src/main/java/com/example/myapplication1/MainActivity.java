package com.example.myapplication1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewTasks;
    private static final int ADD_TASK_REQUEST_CODE = 1;
    private ArrayList<String> taskList;
    private ArrayAdapter<String> adapter;
    private TaskDatabaseHelper dbHelper;
    private TextView messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new TaskDatabaseHelper(this);

        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);

        listViewTasks = findViewById(R.id.listViewTasks);
        listViewTasks.setAdapter(adapter);

        messageText = findViewById(R.id.messageText);
        displayTasks();

        listViewTasks.setOnItemClickListener((adapterView, view, position, id) -> {
            String taskDetails = adapter.getItem(position);
            dbHelper.deleteTask(taskDetails);
            displayTasks();
        });

        if (taskList.isEmpty()) {
            messageText.setVisibility(View.VISIBLE);
        } else {
            messageText.setVisibility(View.GONE);
        }
    }

    private void displayTasks() {
        taskList.clear();
        taskList.addAll(dbHelper.getAllTasks());
        adapter.notifyDataSetChanged();

        if (taskList.isEmpty()) {
            messageText.setVisibility(View.VISIBLE);
        } else {
            messageText.setVisibility(View.GONE);
        }
    }


    public void openAddTask(View view) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivityForResult(intent, ADD_TASK_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_TASK_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String newTask = data.getStringExtra("taskDetails");
            taskList.add(newTask);
            adapter.notifyDataSetChanged();
            dbHelper.insertTask(newTask);
            displayTasks();


            if (taskList.isEmpty()) {
                messageText.setVisibility(View.VISIBLE);
            } else {
                messageText.setVisibility(View.GONE);
            }
        }
    }
}
