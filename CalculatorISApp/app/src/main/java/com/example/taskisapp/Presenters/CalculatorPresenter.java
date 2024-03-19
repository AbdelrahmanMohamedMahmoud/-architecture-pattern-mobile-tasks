package com.example.taskisapp.Presenters;

import com.example.taskisapp.Models.CalculatorModel;
import com.example.taskisapp.Views.CalculatorView;

public class CalculatorPresenter {

    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorPresenter(CalculatorView view) {
        this.view = view;
        this.model = new CalculatorModel();
    }

    public void onDigitButtonClicked(String digit) {
        model.appendDigit(digit);
        view.updateDisplay(model.getDisplay());
    }

    public void onOperatorButtonClicked(String operator) {
        model.setOperator(operator);
    }

    public void onEqualsButtonClicked() {
        model.calculateResult();
        view.updateDisplay(model.getDisplay());
    }

    public void onClearButtonClicked() {
        model.clear();
        view.updateDisplay(model.getDisplay());
    }
}
