package ru.myprojects.geekbrains.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnZero;
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnPlus;
    Button btnMinus;
    Button btnMultiply;
    Button btnDivide;
    Button btnDot;
    Button btnEquals;
    Button btnClear;
    Button btnDelete;
    Button btnChangeTheme;

    Counter counter;
    TextView textView;
    StringBuffer stringBufferTV;
    String keyCounter = "key";

    private final static String TEXT = "PARAM";

    private final Context CONTEXT = this;

    private final int lightThemeValue = R.style.Theme_Geekbrainscalculator;
    private final int darkThemeValue = R.style.Theme_MaterialComponents_DayNight_DarkActionBar;
    private int counterTheme = 1;
    String toastMistakeMessage = "Incorrect input. Please, try again.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Geekbrainscalculator);
        setContentView(R.layout.activity_main);
        initView();
        counter = new Counter();
        stringBufferTV = new StringBuffer();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        else {
            String intentStr = bundle.getString(TEXT);
            String intentLine = checkIntentInput(intentStr);
            if (stringBufferTV.length() == 0 && counter.stringBuffer.length() == 0) {
                stringBufferTV.append(intentLine);
                counter.stringBuffer.append(intentLine);
                textView.setText(intentLine);
            }
            else {
                cleanStringBuffer();
                cleanVariables();
            }
        }
    }

    private void cleanVariables() {
        counter.result = 0;
        counter.valueTwo = 0;
        counter.valueOne = 0;
    }

    private void cleanStringBuffer() {
        stringBufferTV.delete(0, stringBufferTV.length());
        counter.stringBuffer.delete(0,counter.stringBuffer.length());
    }

    private String checkIntentInput(String line) {
        char[] lineChar = line.toCharArray();
        StringBuilder stringBuilderF = new StringBuilder();
        for(int i = 0; i < line.length(); i++) {
            for (int j = 0; j < 9; j++) {
                if (lineChar[i] == j) {
                    stringBuilderF.append(lineChar[i]);
                }
            }
            switch (lineChar[i]) {
                case '+':
                    stringBuilderF.append(lineChar[i]);
                case '-':
                    stringBuilderF.append(lineChar[i]);
                case '*':
                    stringBuilderF.append(lineChar[i]);
                case '/':
                    stringBuilderF.append(lineChar[i]);
                case '.':
                    stringBuilderF.append(lineChar[i]);
                case ' ':
                    stringBuilderF.append(lineChar[i]);
            }
        }
        return (stringBuilderF.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = (Counter) savedInstanceState.getParcelable(keyCounter);
        restoreText();
    }

    private void restoreText() {
        if (textView.getText().equals("")){
            textView.setText(String.valueOf(counter.result));
        }
        else {
            textView.setText(counter.stringBuffer);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(keyCounter,counter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

     private void initView() {
        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnClear = findViewById(R.id.btnClear);
        btnDelete = findViewById(R.id.btnDelete);
        btnDot = findViewById(R.id.btnDot);
        btnChangeTheme = findViewById(R.id.btnSwitchDayNightTheme);
        btnEquals = findViewById(R.id.btnEquals);
        textView = findViewById(R.id.tvText);

        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnChangeTheme.setOnClickListener(this);
    }

    @SuppressLint({"ShowToast", "NonConstantResourceId"})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOne:
                counter.setLine("1");
                stringBufferTV.append("1");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnTwo:
                counter.setLine("2");
                stringBufferTV.append("2");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnThree:
                counter.setLine("3");
                stringBufferTV.append("3");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnFour:
                counter.setLine("4");
                stringBufferTV.append("4");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnFive:
                counter.setLine("5");
                stringBufferTV.append("5");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnSix:
                counter.setLine("6");
                stringBufferTV.append("6");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnSeven:
                counter.setLine("7");
                stringBufferTV.append("7");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnEight:
                counter.setLine("8");
                stringBufferTV.append("8");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnNine:
                counter.setLine("9");
                stringBufferTV.append("9");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnZero:
                counter.setLine("0");
                stringBufferTV.append("0");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnPlus:
                counter.setLine(" + ");
                stringBufferTV.append(" + ");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnMinus:
                counter.setLine(" - ");
                stringBufferTV.append(" - ");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnMultiply:
                counter.setLine(" * ");
                stringBufferTV.append(" * ");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnDivide:
                counter.setLine(" / ");
                stringBufferTV.append(" / ");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnDot:
                counter.setLine(".");
                stringBufferTV.append(".");
                textView.setText(stringBufferTV);
                break;
            case R.id.btnClear:
                textView.setText("");
                stringBufferTV.delete(0,stringBufferTV.length());

                counter.stringBuffer.delete(0, counter.stringBuffer.length());
                counter.setResult(0);
                counter.setValueOne(0);
                counter.setValueTwo(0);
                break;
            case R.id.btnDelete:

                if (stringBufferTV.toString().equals("") &&
                        counter.stringBuffer.toString().equals("")) {
                    cleanVariables();

                    textView.setText("");
                    break;
                }
                else {
                    char valueTvBuffer = stringBufferTV.charAt(stringBufferTV.length() - 1);
                    char valueCounterBuffer = counter.stringBuffer
                            .charAt(counter.stringBuffer.length() - 1);

                    if (valueTvBuffer == ' ' && valueCounterBuffer == ' ') {
                        stringBufferTV.setLength(stringBufferTV.length() - 1);
                        textView.setText(stringBufferTV);

                        counter.stringBuffer.setLength(counter.stringBuffer.length() - 1);
                    }
                    stringBufferTV.setLength(stringBufferTV.length() - 1);
                    textView.setText(stringBufferTV);

                    counter.stringBuffer.setLength(counter.stringBuffer.length() - 1);
                    break;
                }

            case R.id.btnEquals:
                if (stringBufferTV.toString().startsWith("+") ||
                        stringBufferTV.toString().startsWith("-") ||
                        stringBufferTV.toString().startsWith("*") ||
                        stringBufferTV.toString().startsWith("/") ) {
                    Toast toast = Toast.makeText(this, toastMistakeMessage,
                            Toast.LENGTH_LONG);

                    cleanStringBuffer();
                    cleanVariables();
                    break;
                }

                else {
                    cleanVariables();

                    counter.parseStr();

                    textView.setText("");
                    String str = String.valueOf(counter.getResult());
                    textView.setText(str);

                    cleanStringBuffer();
                    break;
                }


            case R.id.btnSwitchDayNightTheme:
                setAppTheme();
                recreate();
        }
    }

    private void setAppTheme() {
        if(counterTheme == 1) {
            setTheme(darkThemeValue);
            counterTheme = 0;
        }
        else if(counterTheme == 0) {
            setTheme(lightThemeValue);
            counterTheme = 1;
        }
    }
}