package com.example.food.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.food.R;
import com.example.food.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        setVariable();
    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(view -> {
            String eml = binding.userEdt.getText().toString();
            String pass = binding.passEdt.getText().toString();

            if(!eml.isEmpty() && !pass.isEmpty()){
                mAuth.signInWithEmailAndPassword(eml, pass).addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else{
                Toast.makeText(LoginActivity.this, "Please fill Username and Password", Toast.LENGTH_SHORT).show();
            }
        });

        binding.signUpTxt.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, SignupActivity.class)));

        binding.facebook.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, FacebookActivity.class)));

        binding.twitter.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, TwitterActivity.class)));

        binding.google.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, GoogleActivity.class)));
    }
}