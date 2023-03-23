package com.example.primenumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText mNumberInput;
    private TextView mValidationMessageView;
    private Button mCheckPrimeBtn;
    private Button mDeleteButton;
    private TextView mResultLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberInput = findViewById(R.id.number_input);
        mValidationMessageView = findViewById(R.id.validation_label);
        mCheckPrimeBtn = findViewById(R.id.check_prime_btn);
        mDeleteButton = findViewById(R.id.delete_btn);
        mResultLabel = findViewById(R.id.result_label);

        PrimeClickListener listener = new PrimeClickListener();
        mCheckPrimeBtn.setOnClickListener(listener);
        mDeleteButton.setOnClickListener(listener);
    }

    private class PrimeClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.check_prime_btn: checkIfPrime(); break;
                case R.id.delete_btn: clearAll(); break;
                default: break;
            }
        }

        private void checkIfPrime() {
            String inputText = mNumberInput.getText().toString();
            mResultLabel.setText("");
            mResultLabel.setVisibility(View.GONE);

            if(isValidInput(inputText)) {
                clearValidationMessage();
                if(isPrime()) {
                    mResultLabel.setText(R.string.is_prime);
                } else {
                    mResultLabel.setText(R.string.not_a_prime);
                }
                mResultLabel.setVisibility(View.VISIBLE);
            } else {
                showValidationMessage(R.string.not_a_natural_number_validation_message);
            }
        }

        private boolean isPrime() {
            return false;
        }

        private void clearAll() {
            mNumberInput.setText("");
            mValidationMessageView.setText("");
            mValidationMessageView.setVisibility(View.GONE);
            mResultLabel.setText("");
            mResultLabel.setVisibility(View.GONE);
        }

        private boolean isValidInput(String inputText) {
            String regex = "^\\d+$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(inputText);
            return m.matches();
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