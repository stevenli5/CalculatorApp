package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonCls, buttonDec, buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEqu;
    TextView edttxt;
    float val1, val2;
    boolean add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        buttonCls = (Button) findViewById(R.id.btn_cls);
        buttonDec = (Button) findViewById(R.id.btn_dec);
        buttonAdd = (Button) findViewById(R.id.btn_add);
        buttonSub = (Button) findViewById(R.id.btn_sub);
        buttonMul = (Button) findViewById(R.id.btn_mul);
        buttonDiv = (Button) findViewById(R.id.btn_div);
        buttonEqu = (Button) findViewById(R.id.btn_equ);

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
                edttxt.setText("");
                val1 = 0;
                val2 = 0;
            }
        });

        buttonDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + ".");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add = true;
                val1 = Float.parseFloat(edttxt.getText() + "");
                edttxt.setText(null);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub = true;
                val1 = Float.parseFloat(edttxt.getText() + "");
                edttxt.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mul = true;
                val1 = Float.parseFloat(edttxt.getText() + "");
                edttxt.setText(null);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                div = true;
                val1 = Float.parseFloat(edttxt.getText() + "");
                edttxt.setText(null);
            }
        });

        buttonEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val2 = Float.parseFloat(edttxt.getText() + "");
                if (val2 == 0.0) {
                    edttxt.setText("Error" + "");
                }
                if (mul == true) {
                    edttxt.setText(val1 * val2 + "");
                    mul = false;
                }
                if (div == true) {
                    edttxt.setText(val1 / val2 + "");
                    div = false;
                }
                if (add == true) {
                    edttxt.setText(val1 + val2 + "");
                    add = false;
                }
                if (sub == true) {
                    edttxt.setText(val1 - val2 + "");
                    sub = false;
                }
            }
        });
    }
}