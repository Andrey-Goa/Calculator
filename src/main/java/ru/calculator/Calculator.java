package ru.calculator;


import ru.calculator.model.Operation;
import ru.calculator.plugin_api.PluginFactory;
import ru.calculator.view.CalculatorView;
import javax.swing.*;


/**
 * Created by andrey-goa on 30.01.17.
 */
public class Calculator {
    public static void main(String[] args) {
        CalculatorView calcView = new CalculatorView("Калькулятор");
        calcView.setVisible(true);
        calcView.run();
    }


    }



