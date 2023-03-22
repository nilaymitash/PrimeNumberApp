package com.example.primenumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    }

    private class PrimeClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

        }

        private boolean isPrime() {
            return false;
        }

        private void clearInput() {

        }
    }
}