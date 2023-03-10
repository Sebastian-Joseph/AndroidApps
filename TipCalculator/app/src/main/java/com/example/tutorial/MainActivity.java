package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math;


import android.os.Bundle;
import android.view.View;

import com.example.tutorial.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });
    }

    private void calculateTip() {
        double cost = Double.parseDouble(binding.costOfService.getText().toString());
        int selectedId = binding.tipOptions.getCheckedRadioButtonId();
        double tipPercentage = 0.0;
        switch(selectedId) {
            case R.id.option_ten_percent:
                tipPercentage = 0.1;
                break;
            case R.id.option_seven_percent:
                tipPercentage = 0.07;
                break;
            default:
                tipPercentage = 0.05;
                break;
        }
        double tip = cost * tipPercentage;
        boolean roundUp = binding.roundTip.isChecked();
        if (roundUp) {
            tip = Math.ceil(tip);
        }
        binding.tipResult.setText(Double.toString(tip));
    }



}