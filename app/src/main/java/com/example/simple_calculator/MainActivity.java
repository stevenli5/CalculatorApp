package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// ==========================================================================
//
// MainActivity.java
//      All calculation functions can be found here.
//
// @author: Steven Li (sli330@uottawa.ca)
// @License: MIT License, github.com/stevenli5/CalculatorApp/blob/master/LICENSE
//
// ==========================================================================

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPi, buttonNeg, buttonCls, buttonDec, buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEqu, buttonDark,
            buttonSin, buttonCos, buttonTan, buttonLog, buttonLn, buttonSqrt, buttonExp, buttonFac, buttonMan;
    TextView edttxt, symView; // symView added for display
    String sym; // to display the sign AND to determine the sign to calculate
    float val1, val2;
    boolean dec; // adding more functionality for decimals
    boolean neg; // checking if value is already negative
    boolean eq; // checking if user has pressed equals yet
    boolean btn; // see if a number is pressed
    boolean pi; // see if pi button is pressed

    public void openManual() {
        Intent intent = new Intent(this, UserManual.class);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dec = false;
        neg = false;
        eq = false;
        btn = false;
        pi = false;

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
        buttonPi = (Button) findViewById(R.id.btn_pi);

        edttxt = (TextView) findViewById(R.id.screen);
        symView = (TextView) findViewById(R.id.symbol);

        buttonNeg = (Button) findViewById(R.id.btn_neg);
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
        buttonMan = (Button) findViewById(R.id.btn_man);

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

        buttonMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openManual();
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (eq) {
                    if (!pi) {
                        edttxt.setText("0");
                        eq = false;
                        sym = null;
                        symView.setText("");
                        dec = false;
                        neg = false;
                        btn = true;
                    } else {
                        edttxt.setText(edttxt.getText());
                    }
                } else {
                    if (pi) {
                        edttxt.setText(edttxt.getText());
                    } else {
                        edttxt.setText(edttxt.getText() + "0");
                        btn = true;
                    }
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (eq) {
                    if (!pi) {
                        edttxt.setText("1");
                        eq = false;
                        sym = null;
                        symView.setText("");
                        dec = false;
                        neg = false;
                        btn = true;
                    } else {
                        edttxt.setText(edttxt.getText());
                    }
                } else {
                    if (pi) {
                        edttxt.setText(edttxt.getText());
                    } else {
                        edttxt.setText(edttxt.getText() + "1");
                        btn = true;
                    }
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (eq) {
                    if (!pi) {
                        edttxt.setText("2");
                        eq = false;
                        sym = null;
                        symView.setText("");
                        dec = false;
                        neg = false;
                        btn = true;
                    } else {
                        edttxt.setText(edttxt.getText());
                    }
                } else {
                    if (pi) {
                        edttxt.setText(edttxt.getText());
                    } else {
                        edttxt.setText(edttxt.getText() + "2");
                        btn = true;
                    }
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (eq) {
                    if (!pi) {
                        edttxt.setText("3");
                        eq = false;
                        sym = null;
                        symView.setText("");
                        dec = false;
                        neg = false;
                        btn = true;
                    } else {
                        edttxt.setText(edttxt.getText());
                    }
                } else {
                    if (pi) {
                        edttxt.setText(edttxt.getText());
                    } else {
                        edttxt.setText(edttxt.getText() + "3");
                        btn = true;
                    }
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (eq) {
                    if (!pi) {
                        edttxt.setText("4");
                        eq = false;
                        sym = null;
                        symView.setText("");
                        dec = false;
                        neg = false;
                        btn = true;
                    } else {
                        edttxt.setText(edttxt.getText());
                    }
                } else {
                    if (pi) {
                        edttxt.setText(edttxt.getText());
                    } else {
                        edttxt.setText(edttxt.getText() + "4");
                        btn = true;
                    }
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (eq) {
                    if (!pi) {
                        edttxt.setText("5");
                        eq = false;
                        sym = null;
                        symView.setText("");
                        dec = false;
                        neg = false;
                        btn = true;
                    } else {
                        edttxt.setText(edttxt.getText());
                    }
                } else {
                    if (pi) {
                        edttxt.setText(edttxt.getText());
                    } else {
                        edttxt.setText(edttxt.getText() + "5");
                        btn = true;
                    }
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (eq) {
                    if (!pi) {
                        edttxt.setText("6");
                        eq = false;
                        sym = null;
                        symView.setText("");
                        dec = false;
                        neg = false;
                        btn = true;
                    } else {
                        edttxt.setText(edttxt.getText());
                    }
                } else {
                    if (pi) {
                        edttxt.setText(edttxt.getText());
                    } else {
                        edttxt.setText(edttxt.getText() + "6");
                        btn = true;
                    }
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (eq) {
                    if (!pi) {
                        edttxt.setText("7");
                        eq = false;
                        sym = null;
                        symView.setText("");
                        dec = false;
                        neg = false;
                        btn = true;
                    } else {
                        edttxt.setText(edttxt.getText());
                    }
                } else {
                    if (pi) {
                        edttxt.setText(edttxt.getText());
                    } else {
                        edttxt.setText(edttxt.getText() + "7");
                        btn = true;
                    }
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (eq) {
                    if (!pi) {
                        edttxt.setText("8");
                        eq = false;
                        sym = null;
                        symView.setText("");
                        dec = false;
                        neg = false;
                        btn = true;
                    } else {
                        edttxt.setText(edttxt.getText());
                    }
                } else {
                    if (pi) {
                        edttxt.setText(edttxt.getText());
                    } else {
                        edttxt.setText(edttxt.getText() + "8");
                        btn = true;
                    }
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (eq) {
                    if (!pi) {
                        edttxt.setText("9");
                        eq = false;
                        sym = null;
                        symView.setText("");
                        dec = false;
                        neg = false;
                        btn = true;
                    } else {
                        edttxt.setText(edttxt.getText());
                    }
                } else {
                    if (pi) {
                        edttxt.setText(edttxt.getText());
                    } else {
                        edttxt.setText(edttxt.getText() + "9");
                        btn = true;
                    }
                }
            }
        });

        buttonPi.setOnClickListener((new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (eq) {
                    edttxt.setText("3.1415926535897932384626433832795028842");
                    eq = false;
                    sym = null;
                    symView.setText("");
                    dec = false;
                    neg = false;
                    pi = true; // pi button has been pressed
                } else {
                    if (btn) {
                        edttxt.setText(edttxt.getText());
                    } else {
                        edttxt.setText("3.1415926535897932384626433832795028842"); // to 39 digits, as the display only supports up to 40 digits
                        pi = true;
                    }
                }
            }
        }));

        buttonCls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sym = null;
                edttxt.setText("");
                symView.setText("");
                val1 = 0;
                val2 = 0;
                dec = false; // reset decimal to no decimal
                neg = false; // reset negative to false
                eq = false; // reset equals to false
                btn = false;
                pi = false;
            }
        });

        buttonDec.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (eq) {
                    edttxt.setText("0." + "");
                    symView.setText("");
                    sym = null;
                    eq = false;
                    dec = true;
                    neg = false;
                    btn = true;
                } else {
                    if (dec) { // if there is already a decimal then continue on, user mistake
                        edttxt.setText(edttxt.getText());
                    } else { // else, we see if there is input from the user already
                        if (edttxt.getText().equals("")) {
                            edttxt.setText("0." + ""); // by default, a null edttxt means the user wants "0."
                        } else {
                            edttxt.setText(edttxt.getText() + "."); // else, we add a decimal
                        }
                        dec = true;
                    }
                }
            }
        });

        buttonNeg.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (eq) {
                    edttxt.setText("-");
                    symView.setText("");
                    sym = null;
                    eq = false;
                    dec = false;
                    neg = true;
                    btn = true;
                } else {
                    if (!neg) { // if the number is already negative skip and reprint the current number
                        String a = (String) edttxt.getText();
                        String b = a.replaceAll(" ", ""); // in order to get rid of the invisible space in between the negative and number
                        edttxt.setText("-" + b);
                        neg = true; // a negative is now present
                    } else {
                        edttxt.setText(edttxt.getText());
                    }
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sym != null) {
                    edttxt.setText(edttxt.getText());
                } else {
                    sym = "+"; // set the case to addition
                    symView.setText("+");
                    val1 = Float.parseFloat(edttxt.getText() + "");
                    edttxt.setText(null);
                    dec = false; // reset decimal boolean to false as we have a new number, val2
                    neg = false; // reset negative to false
                    btn = false;
                    pi = false;
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sym != null) {
                    edttxt.setText(edttxt.getText());
                } else {
                    sym = "-"; // set the case to subtraction
                    symView.setText("-");
                    val1 = Float.parseFloat(edttxt.getText() + "");
                    edttxt.setText(null);
                    dec = false; // reset decimal boolean to false as we have a new number, val2
                    neg = false; // reset negative to false
                    btn = false;
                    pi = false;
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sym != null) {
                    edttxt.setText(edttxt.getText());
                } else {
                    sym = "x"; // set the case to multiplication
                    symView.setText("x");
                    val1 = Float.parseFloat(edttxt.getText() + "");
                    edttxt.setText(null);
                    dec = false; // reset decimal boolean to false as we have a new number, val2
                    neg = false; // reset negative to false
                    btn = false;
                    pi = false;
                }
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sym != null) {
                    edttxt.setText(edttxt.getText());
                } else {
                    sym = "/"; // set the case to division
                    symView.setText("÷");
                    val1 = Float.parseFloat(edttxt.getText() + "");
                    edttxt.setText(null);
                    dec = false; // reset decimal boolean to false as we have a new number, val2
                    neg = false; // reset negative to false
                    btn = false;
                    pi = false;
                }
            }
        });

        buttonSin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                symView.setText("sin");
                val1 = Float.parseFloat(edttxt.getText() + "");
                dec = false; // reset decimal boolean to false
                edttxt.setText(Math.sin(val1) + "");
                neg = false; // reset negative to false
                eq = true; // reset equaled to true
                btn = false;
                pi = false;
            }
        });

        buttonCos.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                symView.setText("cos");
                val1 = Float.parseFloat(edttxt.getText() + "");
                dec = false; // reset decimal boolean to false
                edttxt.setText(Math.cos(val1) + "");
                neg = false; // reset negative to false
                eq = true;
                btn = false;
                pi = false;
            }
        });

        buttonTan.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                symView.setText("tan");
                val1 = Float.parseFloat(edttxt.getText() + "");
                dec = false; // reset decimal boolean to false
                edttxt.setText(Math.tan(val1) + "");
                neg = false; // reset negative to false
                eq = true;
                btn = false;
                pi = false;
            }
        });

        buttonLog.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (neg) {
                    edttxt.setText("Error 4");
                    eq = true;
                } else {
                    symView.setText("log");
                    val1 = Float.parseFloat(edttxt.getText() + "");
                    dec = false; // reset decimal boolean to false
                    edttxt.setText(Math.log10(val1) + "");
                    neg = false; // reset negative to false
                    eq = true;
                    btn = false;
                    pi = false;
                }
            }
        });

        buttonLn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (neg) {
                    edttxt.setText("Error 4");
                    eq = true;
                } else {
                    symView.setText("ln");
                    val1 = Float.parseFloat(edttxt.getText() + "");
                    dec = false; // reset decimal boolean to false
                    edttxt.setText(Math.log(val1) + "");
                    neg = false; // reset negative to false
                    eq = true;
                    btn = false;
                    pi = false;
                }
            }
        });

        buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                symView.setText("√");
                val1 = Float.parseFloat(edttxt.getText() + "");
                if (neg) {
                    edttxt.setText("Error 2");
                    eq = true;
                } else {
                    dec = false; // reset decimal boolean to false
                    edttxt.setText(Math.sqrt(val1) + "");
                    neg = false; // reset negative to false
                    eq = true;
                    btn = false;
                    pi = false;
                }
            }
        });

        buttonExp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (sym != null) {
                    edttxt.setText(edttxt.getText());
                } else {
                    sym = "exp"; // set the case to exponent
                    if (edttxt.getText().length() > 1) {
                        symView.setText("yˣ");
                    } else {
                        symView.setText(edttxt.getText() + "ˣ");
                    }
                    val1 = Float.parseFloat(edttxt.getText() + "");
                    dec = false; // reset decimal boolean to false
                    edttxt.setText(null);
                    neg = false; // reset negative to false
                    btn = false;
                    pi = false;
                }
            }
        });

        buttonFac.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                symView.setText("!");
                val1 = Float.parseFloat(edttxt.getText() + "");
                if (neg) {
                    float i = (int)val1 - 1;
                    while (i > 0) {
                        val1 = val1 * i;
                        i--;
                    } // after this while loop we have successfully 'factorialized' the number
                } else {
                    edttxt.setText("Error 3");
                }
                dec = false; // reset decimal boolean to false
                edttxt.setText(val1 + "");
                neg = false; // reset negative to false
                eq = true;
                btn = false;
                pi = false;
            }
        });

        buttonEqu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                val2 = Float.parseFloat(edttxt.getText() + "");
                if (sym == null) {
                    edttxt.setText(edttxt.getText());
                } else if (sym == "/") {
                    if (val2 == 0.0) {
                        edttxt.setText("Error 1");
                        eq = true;
                    } else {
                        edttxt.setText(val1 / val2 + "");
                        eq = true;
                        btn = false;
                        pi = false;
                    }
                } else {
                    switch (sym) {
                        case "+":
                            edttxt.setText(val1 + val2 + "");
                            eq = true;
                            btn = false;
                            pi = false;
                            break;
                        case "-":
                            edttxt.setText(val1 - val2 + "");
                            eq = true;
                            btn = false;
                            pi = false;
                            break;
                        case "x":
                            edttxt.setText(val1 * val2 + "");
                            eq = true;
                            btn = false;
                            pi = false;
                            break;
                        case "exp":
                            edttxt.setText(Math.pow(val1, val2) + "");
                            eq = true;
                            btn = false;
                            pi = false;
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }
}