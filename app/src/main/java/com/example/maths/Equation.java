package com.example.maths;

public class Equation {
    private String equationSign;
    private String firstArg;
    private String secondArg;
    private String result;

    public Equation(String equationSign, String firstArg, String secondArg, String result) {
        this.equationSign = equationSign;
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        this.result = result;
    }

    public String getEquationSign() {
        return equationSign;
    }

    public String getFirstArg() {
        return firstArg;
    }

    public String getSecondArg() {
        return secondArg;
    }

    public String getResult() {
        return result;
    }
}
