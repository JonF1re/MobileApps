package com.example.lab7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends Activity {

    private EditText editTextPath1, editTextPath2, editTextPath3, editTextPath4, editTextPath5, editTextPath6;
    private Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        editTextPath1 = findViewById(R.id.editTextPath1);
        editTextPath2 = findViewById(R.id.editTextPath2);
        editTextPath3 = findViewById(R.id.editTextPath3);
        editTextPath4 = findViewById(R.id.editTextPath4);
        editTextPath5 = findViewById(R.id.editTextPath5);
        editTextPath6 = findViewById(R.id.editTextPath6);
        buttonOk = findViewById(R.id.buttonOk);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = editTextPath1.getText().toString() + ", " +
                        editTextPath2.getText().toString() + ", " +
                        editTextPath3.getText().toString() + ", " +
                        editTextPath4.getText().toString() + ", " +
                        editTextPath5.getText().toString() + ", " +
                        editTextPath6.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("path", path);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
