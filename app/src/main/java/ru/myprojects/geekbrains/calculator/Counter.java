package ru.myprojects.geekbrains.calculator;

import android.widget.Button;
import android.widget.Toast;

public class Counter {
    double valueOne;
    double valueTwo;
    double result;


    StringBuffer stringBuffer = new StringBuffer();


    public double getResult() {
        return result;
    }

    public void setLine(String line) {
        stringBuffer.append(line);
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setValueTwo(double valueTwo) {
        this.valueTwo = valueTwo;
    }

    public void setValueOne(double valueOne) {
        this.valueOne = valueOne;
    }

    void parseStr () {
        String line = stringBuffer.toString();


            String[] arrSplit = line.split("\\s",3);
        valueOne = Double.parseDouble(arrSplit[0]);
        valueTwo = Double.parseDouble(arrSplit[2]);




        switch (arrSplit[1]) {
            case "+":
                result = valueOne + valueTwo;
                break;
            case "-":
                result = valueOne - valueTwo;
                break;
            case "*":
                result = valueOne * valueTwo;
                break;
            case "/":
                result = valueOne / valueTwo;
                break;
        }
        stringBuffer.delete(0, stringBuffer.length());
    }

}
