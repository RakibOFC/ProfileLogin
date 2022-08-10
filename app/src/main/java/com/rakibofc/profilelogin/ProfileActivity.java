package com.rakibofc.profilelogin;

import static com.rakibofc.profilelogin.LoginActivity.dbEmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    public TextView tvName, tvEmail, tvPhone;
    public Button btnLogout, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        btnLogout = findViewById(R.id.btnLogout);
        btnUpdate = findViewById(R.id.btnUpdate);

        String email;
        String name;
        String phone;

        boolean isUserLogin = getIntent().getBooleanExtra("userLogin", false);

        email = getIntent().getStringExtra("email");

        if (isUserLogin) {

            tvEmail.setText(email);

        } else {

            name = getIntent().getStringExtra("name");
            phone = getIntent().getStringExtra("phone");

            try {
                if (!name.isEmpty()) {
                    tvName.setText(name);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            try {
                if (!email.isEmpty()) {
                    tvEmail.setText(email);

                }
            } catch (NullPointerException e) {
                tvEmail.setText(dbEmail);
            }

            try {
                if (!phone.isEmpty()) {
                    tvPhone.setVisibility(View.VISIBLE);
                    tvPhone.setText(phone);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

        btnUpdate.setOnClickListener(v -> {

            startActivity(new Intent(getApplicationContext(), UpdateActivity.class));
        });

        btnLogout.setOnClickListener(v -> {

            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        });
    }
}