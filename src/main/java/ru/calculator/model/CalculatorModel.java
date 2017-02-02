package ru.calculator.model;

import com.sun.istack.internal.Nullable;

/**
 * Created by andrey-goa on 30.01.17.
 */
public class CalculatorModel  {

    private Operation operation;

    private Double firstNum = null;

    private Double secondNumber = null;




    public void setFirstNum(Double firstNum) {
            this.firstNum = firstNum;
    }

    public Double getFirstNum() {
        return firstNum;
    }

    public void setSecondNumber(Double secondNumber) {
            this.secondNumber = secondNumber;

    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public void setOperation(Operation operation) {
       this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public double getResult(){

        if(operation.isValid(firstNum,secondNumber)) {
            Double res = operation.operate(firstNum,secondNumber);
            return res;
        }else {
            throw new IllegalArgumentException();
        }
    }
}
