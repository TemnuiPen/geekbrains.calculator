package ru.myprojects.geekbrains.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
    Counter counter;
    TextView textView;
    StringBuffer stringBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        counter = new Counter();
        stringBuffer = new StringBuffer();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
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
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
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
        btnDot = findViewById(R.id.btnDot);
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
        btnDot.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
    }

    @SuppressLint({"ShowToast", "NonConstantResourceId"})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOne:
                counter.setLine("1");
                stringBuffer.append("1");
                textView.setText(stringBuffer);
                break;
            case R.id.btnTwo:
                counter.setLine("2");
                stringBuffer.append("2");
                textView.setText(stringBuffer);
                break;
            case R.id.btnThree:
                counter.setLine("3");
                stringBuffer.append("3");
                textView.setText(stringBuffer);
                break;
            case R.id.btnFour:
                counter.setLine("4");
                stringBuffer.append("4");
                textView.setText(stringBuffer);
                break;
            case R.id.btnFive:
                counter.setLine("5");
                stringBuffer.append("5");
                textView.setText(stringBuffer);
                break;
            case R.id.btnSix:
                counter.setLine("6");
                stringBuffer.append("6");
                textView.setText(stringBuffer);
                break;
            case R.id.btnSeven:
                counter.setLine("7");
                stringBuffer.append("7");
                textView.setText(stringBuffer);
                break;
            case R.id.btnEight:
                counter.setLine("8");
                stringBuffer.append("8");
                textView.setText(stringBuffer);
                break;
            case R.id.btnNine:
                counter.setLine("9");
                stringBuffer.append("9");
                textView.setText(stringBuffer);
                break;
            case R.id.btnZero:
                counter.setLine("0");
                stringBuffer.append("0");
                textView.setText(stringBuffer);
                break;
            case R.id.btnPlus:
                counter.setLine(" + ");
                stringBuffer.append("+ ");
                textView.setText(stringBuffer);
                break;
            case R.id.btnMinus:
                counter.setLine(" - ");
                stringBuffer.append(" - ");
                textView.setText(stringBuffer);
                break;
            case R.id.btnMultiply:
                counter.setLine(" * ");
                stringBuffer.append(" * ");
                textView.setText(stringBuffer);
                break;
            case R.id.btnDivide:
                counter.setLine(" / ");
                stringBuffer.append(" / ");
                textView.setText(stringBuffer);
                break;
            case R.id.btnDot:
                counter.setLine(".");
                stringBuffer.append(".");
                textView.setText(stringBuffer);
                break;
            case R.id.btnEquals:
                counter.parseStr();

                textView.setText("");
                String str = String.valueOf(counter.getResult());
                textView.setText(str);

                stringBuffer.delete(0, stringBuffer.length());
                counter.setValueOne(0);
                counter.setValueTwo(0);
                counter.setResult(0);
                break;
        }
    }
}