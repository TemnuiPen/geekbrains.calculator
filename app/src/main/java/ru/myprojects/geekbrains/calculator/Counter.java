package ru.myprojects.geekbrains.calculator;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.Toast;

public class Counter implements Parcelable {
    double valueOne;
    double valueTwo;
    double result;
    StringBuffer stringBuffer;

    public Counter() {
        valueOne = 0;
        valueTwo = 0;
        result = 0;
        stringBuffer = new StringBuffer();
    }

    protected Counter(Parcel in) {
        valueOne = in.readDouble();
        valueTwo = in.readDouble();
        result = in.readDouble();
        String stringLine = stringBuffer.toString();
        stringLine = in.readString();
    }

    public static final Creator<Counter> CREATOR = new Creator<Counter>() {
        @Override
        public Counter createFromParcel(Parcel in) {
            return new Counter(in);
        }

        @Override
        public Counter[] newArray(int size) {
            return new Counter[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(valueOne);
        parcel.writeDouble(valueTwo);
        parcel.writeDouble(result);
        parcel.writeString(stringBuffer.toString());
    }
}
