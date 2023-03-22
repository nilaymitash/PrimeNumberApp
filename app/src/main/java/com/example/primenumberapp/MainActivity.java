package com.example.primenumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText mNumberInput;
    private TextView mValidationMessageView;
    private Button mCheckPrimeBtn;
    private Button mDeleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberInput = findViewById(R.id.number_input);
        mValidationMessageView = findViewById(R.id.validation_label);
        mCheckPrimeBtn = findViewById(R.id.check_prime_btn);
        mDeleteButton = findViewById(R.id.delete_btn);

        PrimeClickListener listener = new PrimeClickListener();
        mCheckPrimeBtn.setOnClickListener(listener);
        mDeleteButton.setOnClickListener(listener);
    }

    private class PrimeClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.check_prime_btn: checkIfPrime(); break;
                case R.id.delete_btn: clearInput(); break;
                default: break;
            }
        }

        private void checkIfPrime() {
            String inputText = mNumberInput.getText().toString();
            if(inputText.equalsIgnoreCase("")) {
                showValidationMessage(R.string.required_validation_message);
            } else {
                validateInput(inputText);
            }
            /*int inputNumber = -1;
            try {
                inputNumber = Integer.parseInt(inputText);
            } catch (NumberFormatException ex) {
                showValidationMessage(R.string.not_a_number_validation_message);
            }

            validateInput(inputNumber);*/
        }

        private boolean isPrime() {
            return false;
        }

        private void clearInput() {

        }

        private void validateInput(String inputText) {
            String regex = "/^[1-9][0-9]*$/";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(inputText);

            if(m.find()) {
                clearValidationMessage();
            } else {
                showValidationMessage(R.string.not_a_natural_number_validation_message);
            }
        }

        private void showValidationMessage(int messageId) {
            mValidationMessageView.setText(messageId);
            mValidationMessageView.setVisibility(View.VISIBLE);
        }

        private void clearValidationMessage() {
            mValidationMessageView.setText("");
            mValidationMessageView.setVisibility(View.GONE);
        }
    }
}