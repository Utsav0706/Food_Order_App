package com.example.food.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.food.R;
import com.example.food.databinding.ActivityCartBinding;
import com.example.food.databinding.ActivityOrderBinding;

public class OrderActivity extends BaseActivity {
    private ActivityOrderBinding binding;
    TextView num;
    private double amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fun_display();

        binding.facebook.setOnClickListener(view -> startActivity(new Intent(OrderActivity.this, FacebookActivity.class)));

        binding.twitter.setOnClickListener(view -> startActivity(new Intent(OrderActivity.this, TwitterActivity.class)));

        binding.google.setOnClickListener(view -> startActivity(new Intent(OrderActivity.this, GoogleActivity.class)));


    }

    private void fun_display() {
        amount = getIntent().getDoubleExtra("Amount", 0);
        binding.amountTxt.setText("$"+amount);
    }


}