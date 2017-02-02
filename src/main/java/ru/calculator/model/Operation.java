package ru.calculator.model;

public interface Operation {
    double operate(Double op1, Double op2);
    String getName();
    boolean isValid(Double op1, Double op2);

}