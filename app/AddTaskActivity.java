import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    public static final String EXTRA_TASK = "com.example.myapplication.TASK";

    private EditText titleEditText, descriptionEditText, dueDateEditText;
    private Spinner prioritySpinner, categorySpinner, statusSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        dueDateEditText = findViewById(R.id.dueDateEditText);
        prioritySpinner = findViewById(R.id.prioritySpinner);
        categorySpinner = findViewById(R.id.categorySpinner);
        statusSpinner = findViewById(R.id.statusSpinner);

        ArrayAdapter<CharSequence> priorityAdapter = ArrayAdapter.createFromResource(
                this, R.array.priority_options, android.R.layout.simple_spinner_item);
        priorityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prioritySpinner.setAdapter(priorityAdapter);

        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(
                this, R.array.category_options, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);

        ArrayAdapter<CharSequence> statusAdapter = ArrayAdapter.createFromResource(
                this, R.array.status_options, android.R.layout.simple_spinner_item);
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(statusAdapter);
    }
@Override
    public void addTask(View view) {
        String title = titleEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        String dueDate = dueDateEditText.getText().toString();
        String priority = prioritySpinner.getSelectedItem().toString();
        String category = categorySpinner.getSelectedItem().toString();
        String status = statusSpinner.getSelectedItem().toString();

        String taskDetails = "Title: " + title +
                "\nDescription: " + description +
                "\nDue Date: " + dueDate +
                "\nPriority: " + priority +
                "\nCategory: " + category +
                "\nStatus: " + status;

        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_TASK, taskDetails);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
