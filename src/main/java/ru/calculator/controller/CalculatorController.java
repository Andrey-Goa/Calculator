package ru.calculator.controller;


import ru.calculator.model.CalculatorModel;
import ru.calculator.model.Operation;
import sun.nio.cs.UTF_32;


import javax.swing.*;

/**
 * Created by andrey-goa on 30.01.17.
 */
public class CalculatorController {

    private static CalculatorController instance = null;
    private JTextField  resultText = null;
    public void setTextComponent(JTextField textComponent) {
        this.resultText = textComponent;
    }
    private CalculatorModel calculatorModel = new CalculatorModel();

    public static CalculatorController getInstance() {
        if (instance==null) {
            instance = new CalculatorController();
        }
        return instance;
    }

    public void SetNumberText(String num) {
        String lastRes = this.resultText.getText();
        if ((lastRes.equals("")) && (num.equals("."))){
            num = "0.";
        }
        if (lastRes.contains(".") && (num.equals("."))){
            num = "";
        }
        this.resultText.setText(lastRes+num);
    }

    public void delLastNumber() {
        String lastRes = this.resultText.getText();
        if(lastRes.contains("nfinity") || (lastRes.contains("Error"))){
            this.delAllNumber();
        }
        else if(!lastRes.isEmpty()) {
            this.resultText.setText(lastRes.substring(0, lastRes.length() - 1));
        }

    }

    public void delAllNumber() {
        this.resultText.setText("");

    }

   public void setOperation(Operation operation) {
       String fn = this.resultText.getText();
       try {
           if(fn.isEmpty()){
               if(operation.getName().equals("-")){
                   this.resultText.setText("-");
               }else {
                   calculatorModel.setOperation(operation);
                   this.resultText.setText("");
               }
           } else {


               if (calculatorModel.getOperation() != null) {
                   this.getResult();
                   this.setOperation(operation);

               } else {

                   calculatorModel.setFirstNum(Double.parseDouble(fn));
                   calculatorModel.setOperation(operation);
                   this.resultText.setText("");


               }
           }
       }catch(NumberFormatException e){
           this.resultText.setText("Error");
       }

   }


    public void getResult(){
        String resultString = "";
        String sn = this.resultText.getText();
        Double result;
        if(calculatorModel.getOperation()==null){
            this.resultText.setText(sn);
        }else {
            try {
                if (sn.isEmpty()) {
                    calculatorModel.setSecondNumber(null);
                } else {
                    calculatorModel.setSecondNumber(Double.parseDouble(sn));
                }
                result = calculatorModel.getResult();
                resultString = String.valueOf(result);
                this.resultText.setText(resultString);
                calculatorModel.setFirstNum(result);
                calculatorModel.setOperation(null);
                calculatorModel.setSecondNumber(null);

            } catch (IllegalArgumentException e) {
                this.resultText.setText("Error");
            }
        }
    }


}

