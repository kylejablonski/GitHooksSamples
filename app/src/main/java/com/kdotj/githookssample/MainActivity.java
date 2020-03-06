package com.kdotj.githookssample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private CalculatorModel mCalculatorModel;
    private int optionSelected = 0;
    private EditText etNumber1;
    private EditText etNumber2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculatorModel = new CalculatorModel();

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mCalculatorModel.getSpinnerOptions()));
        spinner.setOnItemSelectedListener(this);
        etNumber1 = findViewById(R.id.number1);
        etNumber2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);
        Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(calculateListener);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        optionSelected = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private final View.OnClickListener calculateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            try {
                Double.parseDouble(etNumber1.getText().toString());
                Double.parseDouble(etNumber2.getText().toString());
            } catch (NumberFormatException ex) {
                Toast.makeText(MainActivity.this, "error one of these isn't a number", Toast.LENGTH_SHORT).show();
                return;
            }

            double number1 = Double.valueOf(etNumber1.getText().toString());
            double number2 = Double.valueOf(etNumber2.getText().toString());

            if (number2 == 0) {
                Toast.makeText(MainActivity.this, "Can't divide by 0 silly.", Toast.LENGTH_SHORT).show();
                return;
            }

            String value;
            switch (optionSelected) {
                case 0:
                    value = String.valueOf(mCalculatorModel.addNumbers(number1, number2));
                    break;
                case 1:
                    value = String.valueOf(mCalculatorModel.subtractNumbers(number1, number2));
                    break;
                case 2:
                    value = String.valueOf(mCalculatorModel.multiplyTwoNumbers(number1, number2));
                    break;
                default:
                    value = String.valueOf(mCalculatorModel.divideTwoNumbers(number1, number2));
                    break;
            }


            result.setText(value);

        }
    };

}
