package com.example.taskisapp.Models;

public class CalculatorModel {

    private StringBuilder display;
    private double operand1;
    private String operator;
    private boolean isNewOperand;

    public CalculatorModel() {
        this.display = new StringBuilder();
        this.operand1 = 0;
        this.operator = "";
        this.isNewOperand = true;
    }

    public void appendDigit(String digit) {
        if (isNewOperand) {
            display.setLength(0);
            isNewOperand = false;
        }
        display.append(digit);
    }

    public void setOperator(String operator) {
        if (!isNewOperand) {
            this.operand1 = Double.parseDouble(display.toString());
            this.operator = operator;
            isNewOperand = true;
        }
    }

    public void calculateResult() {
        if (!operator.isEmpty()) {
            double operand2 = Double.parseDouble(display.toString());
            switch (operator) {
                case "+":
                    operand1 += operand2;
                    break;
                case "-":
                    operand1 -= operand2;
                    break;
                case "*":
                    operand1 *= operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        operand1 /= operand2;
                    } else {
                        // Handle division by zero error
                        operand1 = Double.NaN;
                    }
                    break;
            }
            display.setLength(0);
            display.append(operand1);
            isNewOperand = true;
        }
    }

    public void clear() {
        display.setLength(0);
        operand1 = 0;
        operator = "";
        isNewOperand = true;
    }

    public String getDisplay() {
        return display.toString();
    }
}
