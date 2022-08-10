package com.rakibofc.profilelogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public EditText etEmail, etPassword;

    public Button btnLogin;

    public static String dbEmail, dbPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        dbEmail = "rakib@gmail.com";
        dbPassword = "123";

        btnLogin.setOnClickListener(view -> {

            String inputEmail = etEmail.getText().toString().trim();
            String inputPassword = etPassword.getText().toString().trim();

            if (dbEmail.equals(inputEmail) && dbPassword.equals(inputPassword)){

                Intent loginIntent = new Intent(getApplicationContext(), ProfileActivity.class);

                loginIntent.putExtra("userLogin", true);
                loginIntent.putExtra("email", inputEmail);
                startActivity(loginIntent);
                finish();

            } else {

                Toast.makeText(getApplicationContext(), "Login Failed :(", Toast.LENGTH_SHORT).show();
            }
        });
    }
}