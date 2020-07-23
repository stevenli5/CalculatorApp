package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// ==========================================================================
//
// UserManual.java
//      Basic function for going back to calculator from the User Manual.
//
// @author: Steven Li (sli330@uottawa.ca)
// @License: MIT License, github.com/stevenli5/CalculatorApp/blob/master/LICENSE
//
// ==========================================================================

public class UserManual extends AppCompatActivity {
    Button buttonBack;

    public void openCalculator() {
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manual);

        buttonBack = (Button) findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalculator();
            }
        });
    }
}