package com.example.lab7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPhone, editTextName, editTextSurname;
    private Button buttonRegistration;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "TaxiAppPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate called");

        editTextPhone = findViewById(R.id.editTextPhone);
        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        buttonRegistration = findViewById(R.id.buttonRegistration);

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        loadUserData();

        buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("phone", editTextPhone.getText().toString());
                intent.putExtra("name", editTextName.getText().toString());
                intent.putExtra("surname", editTextSurname.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void loadUserData() {
        String phone = sharedPreferences.getString("phone", "");
        String name = sharedPreferences.getString("name", "");
        String surname = sharedPreferences.getString("surname", "");

        if (!phone.isEmpty() || !name.isEmpty() || !surname.isEmpty()) {
            editTextPhone.setText(phone);
            editTextName.setText(name);
            editTextSurname.setText(surname);
            buttonRegistration.setText("Вход");
        } else {
            buttonRegistration.setText("Регистрация");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause called");
        saveUserData();
    }

    private void saveUserData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("phone", editTextPhone.getText().toString());
        editor.putString("name", editTextName.getText().toString());
        editor.putString("surname", editTextSurname.getText().toString());
        editor.apply();
    }
}