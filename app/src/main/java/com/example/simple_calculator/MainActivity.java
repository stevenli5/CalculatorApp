package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonCls, buttonDec, buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEqu, buttonDark,
            buttonSin, buttonCos, buttonTan, buttonLog, buttonLn, buttonSqrt, buttonExp, buttonFac, buttonMan;
    TextView edttxt, symView; // symView added for display
    String sym; // to display the sign AND to determine the sign to calculate
    float val1, val2;
    boolean dec; // adding more functionality for decimals

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dec = false;

        button0 = (Button) findViewById(R.id.btn0);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        button7 = (Button) findViewById(R.id.btn7);
        button8 = (Button) findViewById(R.id.btn8);
        button9 = (Button) findViewById(R.id.btn9);

        edttxt = (TextView) findViewById(R.id.screen);
        symView = (TextView) findViewById(R.id.symbol);

        buttonCls = (Button) findViewById(R.id.btn_cls);
        buttonDec = (Button) findViewById(R.id.btn_dec);
        buttonAdd = (Button) findViewById(R.id.btn_add);
        buttonSub = (Button) findViewById(R.id.btn_sub);
        buttonMul = (Button) findViewById(R.id.btn_mul);
        buttonDiv = (Button) findViewById(R.id.btn_div);
        buttonEqu = (Button) findViewById(R.id.btn_equ);
        buttonDark = (Button) findViewById(R.id.btn_dark);
        buttonSin = (Button) findViewById(R.id.btn_sin);
        buttonCos = (Button) findViewById(R.id.btn_cos);
        buttonTan = (Button) findViewById(R.id.btn_tan);
        buttonMan = (Button) findViewById(R.id.btn_man);
        buttonLog = (Button) findViewById(R.id.btn_log);
        buttonLn = (Button) findViewById(R.id.btn_ln);
        buttonSqrt = (Button) findViewById(R.id.btn_sqt);
        buttonExp = (Button) findViewById(R.id.btn_exp);
        buttonFac = (Button) findViewById(R.id.btn_fac);

        SharedPreferences appMode = getSharedPreferences("AppSettingPrefs", 0); //default app mode
        final boolean isNightModeOn = appMode.getBoolean("NightMode", false); //default light mode
        final SharedPreferences.Editor appEdit = appMode.edit();

        if(isNightModeOn) { // not compatible with landscape mode, therefore app is kept in portrait mode
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            buttonDark.setText("Clear and Disable Dark Mode"); // changing the text of Enable/Disable Dark Mode
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            buttonDark.setText("Clear and Enable Dark Mode"); // changing the text of Enable/Disable Dark Mode
        }

        buttonDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // simple onClickListener to determine if the button has been clicked, like in previous project
                if (isNightModeOn) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    appEdit.putBoolean("NightMode", false);
                    appEdit.apply(); // apply the edits
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    appEdit.putBoolean("NightMode", true);
                    appEdit.apply(); // apply the edits
                }
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "9");
            }
        });

        buttonCls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sym = null;
                edttxt.setText("");
                symView.setText("");
                val1 = 0;
                val2 = 0;
                dec = false;
            }
        });

        buttonDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dec) { // if there is already a decimal then continue on, user mistake
                    edttxt.setText(edttxt.getText());
                    dec = true;
                } else if (!dec) { // else, we see if there is input from the user already
                    if (edttxt.getText().equals("")) {
                        edttxt.setText("0." + ""); // by default, a null edttxt means the user wants "0."
                    } else {
                        edttxt.setText(edttxt.getText() + "."); // else, we add a decimal
                    }
                    dec = true;
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sym = "+"; // set the case to addition
                symView.setText("+");
                val1 = Float.parseFloat(edttxt.getText() + "");
                edttxt.setText(null);
                dec = false; // reset decimal boolean to false as we have a new number, val2
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sym = "-"; // set the case to subtraction
                symView.setText("-");
                val1 = Float.parseFloat(edttxt.getText() + "");
                edttxt.setText(null);
                dec = false; // reset decimal boolean to false as we have a new number, val2
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sym = "x"; // set the case to multiplication
                symView.setText("x");
                val1 = Float.parseFloat(edttxt.getText() + "");
                edttxt.setText(null);
                dec = false; // reset decimal boolean to false as we have a new number, val2
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sym = "÷"; // set the case to division
                symView.setText("÷");
                val1 = Float.parseFloat(edttxt.getText() + "");
                edttxt.setText(null);
                dec = false; // reset decimal boolean to false as we have a new number, val2
            }
        });

        buttonSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sym = "sin"; // set the case to sin
                symView.setText("sin");
                val1 = Float.parseFloat(edttxt.getText() + "");
//                edttxt.setText(null);
                dec = false; // reset decimal boolean to false as we have a new number, val2
                edttxt.setText(Math.sin(val1) + "");
                sym = null;
            }
        });

        buttonEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val2 = Float.parseFloat(edttxt.getText() + "");
                // temporary code below for testing - use switch(sign) later
                if (sym == "+") {
                    edttxt.setText(val1+val2 + "");
                }
                if (sym == "-") {
                    edttxt.setText(val1-val2 + "");
                }
                if (sym == "x") {
                    edttxt.setText(val1*val2 + "");
                }
                if (sym == "÷") {
                    edttxt.setText(val1/val2 + "");
                }
                // after equals, must reset the display afterwards
            }
        });


    }
}