package com.rakibofc.profilelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    public EditText etName, etEmail, etPhone;
    public Button btnCancel, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnCancel = findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(v -> onBackPressed());

        btnUpdate.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            Intent updateIntent = new Intent(getApplicationContext(), ProfileActivity.class);

            if (!name.isEmpty()) {
                updateIntent.putExtra("name", name);
            }

            if (!email.isEmpty()) {
                updateIntent.putExtra("email", email);
            }

            if (!phone.isEmpty()) {
                updateIntent.putExtra("phone", phone);
            }

            startActivity(updateIntent);
            finish();
        });
    }
}