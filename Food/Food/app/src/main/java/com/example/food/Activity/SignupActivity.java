package com.example.food.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.food.R;
import com.example.food.databinding.ActivitySignupBinding;

public class SignupActivity extends BaseActivity {
    ActivitySignupBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
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
        binding.signupBtn.setOnClickListener(view -> {
            String eml = binding.userEdt.getText().toString();
            String pass = binding.passEdt.getText().toString();

            if(pass.length()<6){
                Toast.makeText(SignupActivity.this, "Your Password must be 6 character", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.createUserWithEmailAndPassword(eml, pass).addOnCompleteListener(SignupActivity.this, task -> {
                if(task.isComplete()){
                    Log.i(Tag, "onComplete");
                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                }
                else{
                    Log.i(Tag, "Failure" + task.getException());
                    Toast.makeText(SignupActivity.this,"Authentication Failed" , Toast.LENGTH_SHORT).show();
                }
            });
        });

        binding.loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });
    }
}