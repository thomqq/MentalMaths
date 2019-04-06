package com.example.maths.creater;

import com.example.maths.Equation;
import com.example.maths.EquationCreater;

import java.util.Random;

public class DivideEquationCreater implements EquationCreater {
    Integer firstArg = 0;
    Integer secondArd = 0;
    Integer result = 0;

    @Override
    public Equation getNextEquation() {
        next();
        return new Equation("/", firstArg.toString(), secondArd.toString(), result.toString());
    }

    private void next() {
        Random random = new Random(System.currentTimeMillis());
        result = random.nextInt(10);
        secondArd = random.nextInt(10);
        firstArg = secondArd * result;
    }
}
