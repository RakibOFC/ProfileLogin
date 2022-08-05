package com.rakibofc.profilelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    public TextView tvName, tvEmail, tvPhone;
    public Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        btnLogout = findViewById(R.id.btnLogout);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");

        tvName.setText(name);
        tvEmail.setText(email);
        tvPhone.setText(phone);

        btnLogout.setOnClickListener(v -> {

            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        });
    }
}