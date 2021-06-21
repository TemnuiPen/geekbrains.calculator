package ru.myprojects.geekbrains.calculator;

import android.widget.Button;

public class Counter {
    double valueOne;
    double valueTwo;
    double result;

    StringBuffer stringBuffer = new StringBuffer();


    public void setLine(String line) {
        stringBuffer.append(line);
    }

    void parseStr () {
        String line = stringBuffer.toString();
        String[] arrSplit = line.split(" ",3);
        valueOne = Double.parseDouble(arrSplit[1]);
        valueTwo = Double.parseDouble(arrSplit[3]);

        switch (arrSplit[2]) {
            case "+":
                result = valueOne + valueTwo;
            case "-":
                result = valueOne - valueTwo;
            case "*":
                result = valueOne * valueTwo;
            case "/":
                result = valueOne / valueTwo;
        }
    }

}
