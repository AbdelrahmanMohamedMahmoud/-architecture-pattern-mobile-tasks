package com.example.taskisapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.taskisapp.Presenters.CalculatorPresenter;
import com.example.taskisapp.R;
import com.example.taskisapp.Views.CalculatorView;

public class MainActivity extends AppCompatActivity implements CalculatorView {

    private TextView displayTextView;
    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTextView = findViewById(R.id.displayTextView);
        presenter = new CalculatorPresenter(this);

        setupDigitButtons();
        setupOperatorButtons();
        setupEqualsButton();
        setupClearButton();
    }

    private void setupDigitButtons() {
        for (int i = 0; i <= 9; i++) {
            int digitButtonId = getResources().getIdentifier("button_" + i, "id", getPackageName());
            Button digitButton = findViewById(digitButtonId);
            digitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.onDigitButtonClicked(((Button) v).getText().toString());
                }
            });
        }
    }

    private void setupOperatorButtons() {
        Button addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onOperatorButtonClicked("+");
            }
        });

        Button subtractButton = findViewById(R.id.button_subtract);
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onOperatorButtonClicked("-");
            }
        });

        Button multiplyButton = findViewById(R.id.button_multiply);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onOperatorButtonClicked("*");
            }
        });

        Button divideButton = findViewById(R.id.button_divide);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onOperatorButtonClicked("/");
            }
        });
    }

    private void setupEqualsButton() {
        Button equalsButton = findViewById(R.id.button_equals);
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onEqualsButtonClicked();
            }
        });
    }

    private void setupClearButton() {
        Button clearButton = findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClearButtonClicked();
            }
        });
    }

    @Override
    public void updateDisplay(String display) {
        displayTextView.setText(display);
    }
}
