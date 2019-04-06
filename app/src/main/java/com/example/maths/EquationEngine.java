package com.example.maths;

import com.example.maths.creater.DivideEquationCreater;
import com.example.maths.creater.MinusEquationCreater;
import com.example.maths.creater.MultipleEquationCreater;
import com.example.maths.creater.PlusEquationCreater;

public class EquationEngine implements EquationView {
    private EquationTypeEnum equationTypeEnum;
    private EquationStateProcessEnum equationStateProcess;

    private EquationCreater equationCreater;
    private static final Equation emptyEquation = new Equation("", "", "", "Wybierz");
    private static Equation currentEquation;

    public EquationEngine() {
        equationTypeEnum = EquationTypeEnum.none;
        equationStateProcess = EquationStateProcessEnum.none;
    }

    public void setEquationType(EquationTypeEnum typeEnum) {
        this.equationTypeEnum = typeEnum;
        this.equationStateProcess = EquationStateProcessEnum.showEquation;
        switch (typeEnum) {
            case plus:
                equationCreater = new PlusEquationCreater();
                break;
            case minus:
                equationCreater = new MinusEquationCreater();
                break;
            case multiple:
                equationCreater = new MultipleEquationCreater();
                break;
            case divide:
                equationCreater = new DivideEquationCreater();
                break;
            default:
                equationCreater = null;
                break;
        }
        if( equationCreater != null ) {
            currentEquation = equationCreater.getNextEquation();
        }
    }

    public void process() {
        if (equationStateProcess == EquationStateProcessEnum.showEquation) {
            equationStateProcess = EquationStateProcessEnum.hideEquation;
        } else if (equationStateProcess == EquationStateProcessEnum.hideEquation) {
            equationStateProcess = EquationStateProcessEnum.getShowEquationWithResult;
        } else if (equationStateProcess == EquationStateProcessEnum.getShowEquationWithResult) {
            currentEquation = equationCreater.getNextEquation();
            equationStateProcess = EquationStateProcessEnum.showEquation;
        }
    }


    @Override
    public String getEquationText() {
        if (equationStateProcess == EquationStateProcessEnum.none) {
            return prepareEquationText(emptyEquation);
        } else {
            if (equationStateProcess == EquationStateProcessEnum.showEquation || equationStateProcess == EquationStateProcessEnum.getShowEquationWithResult) {
                return prepareEquationText(currentEquation);
            } else {
                return "";
            }
        }
    }

    @Override
    public String getEquationResult() {
        if (equationStateProcess == EquationStateProcessEnum.none) {
            return prepareResult(emptyEquation);
        } else {
            if (equationStateProcess == EquationStateProcessEnum.getShowEquationWithResult) {
                return prepareResult(currentEquation);
            } else {
                return "";
            }
        }
    }

    private String prepareEquationText(Equation equation) {
        return equation.getFirstArg() + " " + equation.getEquationSign() + " " + equation.getSecondArg();
    }

    private String prepareResult(Equation equation) {
        return equation.getResult();
    }

}
