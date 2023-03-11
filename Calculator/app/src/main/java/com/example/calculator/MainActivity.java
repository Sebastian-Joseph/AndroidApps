package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

   private TextView resultTextView;
   private Button Clear;
   private Button Equals;
   private Button Add;
   private Button Subtract;
   private Button Multiply;
   private Button Divide;
   private Button Parenthesis;
   private Button Percent;
   private Button PlusMinus;
   private Button Dot;

   private Button Zero;
   private Button One;
   private Button Two;
   private Button Three;
   private Button Four;
   private Button Five;
   private Button Six;
   private Button Seven;
   private Button Eight;
   private Button Nine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finds the TextView and the operation buttons
        resultTextView = findViewById(R.id.calculator_display);
        Clear = findViewById(R.id.clear);
        Parenthesis = findViewById(R.id.parenthesis);
        Percent = findViewById(R.id.percent);
        Divide = findViewById(R.id.divide);
        Multiply = findViewById(R.id.multiply);
        Subtract = findViewById(R.id.minus);
        Add = findViewById(R.id.plus);
        PlusMinus = findViewById(R.id.plus_minus);
        Dot = findViewById(R.id.dot);

        // Click Listeners for the digits
        One = findViewById(R.id.one);
        Two = findViewById(R.id.two);
        Three = findViewById(R.id.three);
        Four = findViewById(R.id.four);
        Five = findViewById(R.id.five);
        Six = findViewById(R.id.six);
        Seven = findViewById(R.id.seven);
        Eight = findViewById(R.id.eight);
        Nine = findViewById(R.id.nine);

    }





}