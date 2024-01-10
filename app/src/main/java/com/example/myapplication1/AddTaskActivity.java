package com.example.myapplication1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    private EditText editTitle, editDescription, editDueDate;
    private Spinner spinnerPriority, spinnerCategory, spinnerStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editTitle = findViewById(R.id.titleEditText);
        editDescription = findViewById(R.id.descriptionEditText);
        editDueDate = findViewById(R.id.dueDateEditText);

        spinnerPriority = findViewById(R.id.prioritySpinner);
        spinnerCategory = findViewById(R.id.categorySpinner);
        spinnerStatus = findViewById(R.id.statusSpinner);

        setupSpinners();

        Button btnAddTask = findViewById(R.id.btnAddTask);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask();
            }
        });
    }

    private void setupSpinners() {
        ArrayAdapter<CharSequence> priorityAdapter = ArrayAdapter.createFromResource(
                this, R.array.priority_options, android.R.layout.simple_spinner_item);
        priorityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPriority.setAdapter(priorityAdapter);

        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(
                this, R.array.category_options, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);

        ArrayAdapter<CharSequence> statusAdapter = ArrayAdapter.createFromResource(
                this, R.array.status_options, android.R.layout.simple_spinner_item);
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(statusAdapter);
    }

    private void addTask() {
        String title = editTitle.getText().toString();
        String description = editDescription.getText().toString();
        String dueDate = editDueDate.getText().toString();
        String priority = spinnerPriority.getSelectedItem().toString();
        String category = spinnerCategory.getSelectedItem().toString();
        String status = spinnerStatus.getSelectedItem().toString();

        if (!title.isEmpty() && !description.isEmpty() && !dueDate.isEmpty()) {
            String taskDetails = "Title: " + title +
                    "\nDescription: " + description +
                    "\nDue Date: " + dueDate +
                    "\nPriority: " + priority +
                    "\nCategory: " + category +
                    "\nStatus: " + status;

            Intent resultIntent = new Intent();
            resultIntent.putExtra("taskDetails", taskDetails);
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }
}
