package com.example.maths.creater;

import com.example.maths.Equation;
import com.example.maths.EquationCreater;

import java.util.Random;

public class PlusEquationCreater implements EquationCreater {

    Integer firstArg = 0;
    Integer secondArd = 0;
    Integer result = 0;

    @Override
    public Equation getNextEquation() {
        next();
        return new Equation("+", firstArg.toString(), secondArd.toString(), result.toString());
    }

    private void next() {
        Random random = new Random(System.currentTimeMillis());
        firstArg = random.nextInt(100);
        secondArd = random.nextInt(100);
        result = firstArg + secondArd;
    }
}
