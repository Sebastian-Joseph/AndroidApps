package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Button;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Button zero, one, two, three, four, five, six, seven, eight, nine;
    private Button plus, minus, multiply, divide, dot, clear, equals, parenthesis, plusminus, percent;
    private TextView outputTextView;
    private String currentExpression = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        dot = findViewById(R.id.dot);
        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equal);
        parenthesis = findViewById(R.id.parenthesis);
        plusminus = findViewById(R.id.plus_minus);
        percent = findViewById(R.id.percent);
        outputTextView = findViewById(R.id.display);

        String lastInput = "";

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "0";
                outputTextView.setText(currentExpression);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "1";
                outputTextView.setText(currentExpression);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "2";
                outputTextView.setText(currentExpression);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "3";
                outputTextView.setText(currentExpression);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "4";
                outputTextView.setText(currentExpression);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "5";
                outputTextView.setText(currentExpression);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "6";
                outputTextView.setText(currentExpression);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "7";
                outputTextView.setText(currentExpression);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "8";
                outputTextView.setText(currentExpression);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "9";
                outputTextView.setText(currentExpression);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "+";
                outputTextView.setText(currentExpression);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "-";
                outputTextView.setText(currentExpression);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "*";
                outputTextView.setText(currentExpression);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression += "/";
                outputTextView.setText(currentExpression);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentExpression = "";
                outputTextView.setText(currentExpression);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = evaluateExpression(currentExpression);
                outputTextView.setText(Double.toString(result));
            }
        });

        parenthesis.setOnClickListener(new View.OnClickListener() {
            private static final char OPENING_PARENTHESIS = '(';
            private static final char CLOSING_PARENTHESIS = ')';

            @Override
            public void onClick(View v) {
                int length = currentExpression.length();
                if (length == 0 || currentExpression.charAt(length - 1) == CLOSING_PARENTHESIS) {
                    // If the expression is empty or the last character is a closing parenthesis, add an opening parenthesis
                    currentExpression += OPENING_PARENTHESIS;
                } else {
                    // Otherwise, get the last character in the expression
                    char lastChar = currentExpression.charAt(length - 1);

                    switch (lastChar) {
                        case '+':
                        case '-':
                        case '*':
                        case '/':
                        case OPENING_PARENTHESIS:
                            // If the last character is an operator or an opening parenthesis, add another opening parenthesis
                            currentExpression += OPENING_PARENTHESIS;
                            break;
                        case CLOSING_PARENTHESIS:
                            // If the last character is a closing parenthesis, add a closing parenthesis
                            currentExpression += CLOSING_PARENTHESIS;
                            break;
                        default:
                            // If the last character is a digit, add a closing parenthesis
                            currentExpression = new StringBuilder(currentExpression)
                                    .insert(length, CLOSING_PARENTHESIS)
                                    .toString();
                            break;
                    }
                }

                outputTextView.setText(currentExpression);
            }
        });


        plusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = outputTextView.getText().toString();

                if (currentText.equals("")) {
                    // If the current text is empty, assume 0 and negate it
                    outputTextView.setText("-");
                } else {
                    try {
                        // Try parsing the current text as a number
                        double currentValue = Double.parseDouble(currentText);

                        // Negate the current value and set it as the new text
                        outputTextView.setText(Double.toString(-currentValue));
                    } catch (NumberFormatException e) {
                        // If the current text is not a valid number, clear the text
                        outputTextView.setText("");
                    }
                }
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentExpression.length() > 0) {
                    // Get the last character in the expression
                    char lastChar = currentExpression.charAt(currentExpression.length() - 1);

                    if (Character.isDigit(lastChar)) {
                        // If the last character is a digit, add a percent sign
                        String[] tokens = currentExpression.split("(?<=[-+*/])|(?=[-+*/])");
                        int lastIndex = tokens.length - 1;
                        String lastToken = tokens[lastIndex];
                        double value = Double.parseDouble(lastToken) / 100.0;
                        tokens[lastIndex] = Double.toString(value);
                        currentExpression = TextUtils.join("", tokens);
                    }
                }

                outputTextView.setText(currentExpression);
            }
        });


        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentExpression.isEmpty()) {
                    // If the expression is empty, insert a leading zero before the dot
                    currentExpression = "0.";
                } else if (currentExpression.endsWith(".")) {
                    // If the expression already ends with a dot, do nothing
                    return;
                } else if (Character.isDigit(currentExpression.charAt(currentExpression.length() - 1))) {
                    // If the last character is a digit, append the dot
                    currentExpression += ".";
                } else {
                    // Otherwise, insert a leading zero before the dot
                    currentExpression += "0.";
                }
                outputTextView.setText(currentExpression);
            }
        });







    }


    private double evaluateExpression(String expression) {
        // Create a stack to hold the operands
        Stack<Double> operands = new Stack<>();

        // Create a stack to hold the operators
        Stack<Character> operators = new Stack<>();

        // Iterate through the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                // If the current character is a digit or a decimal point,
                // continue reading the operand until the end
                StringBuilder operand = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    operand.append(expression.charAt(i));
                    i++;
                }
                i--;

                // Convert the operand to a double and push it onto the stack
                operands.push(Double.parseDouble(operand.toString()));
            } else if (c == '(') {
                // If the current character is an opening parenthesis, push it onto the operator stack
                operators.push(c);
            } else if (c == ')') {
                // If the current character is a closing parenthesis, evaluate the subexpression
                // between the matching parentheses and push the result onto the operand stack
                while (operators.peek() != '(') {
                    double b = operands.pop();
                    double a = operands.pop();
                    char operator = operators.pop();
                    double result = applyOperator(a, b, operator);
                    operands.push(result);
                }
                operators.pop(); // Pop the opening parenthesis
            } else if (isOperator(c)) {
                // If the current character is an operator, evaluate the operators on the top of the stack
                // until the top operator has lower precedence than the current operator, or the stack is empty,
                // then push the current operator onto the stack
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    double b = operands.pop();
                    double a = operands.pop();
                    char operator = operators.pop();
                    double result = applyOperator(a, b, operator);
                    operands.push(result);
                }
                operators.push(c);
            }
        }

        // Evaluate any remaining operators on the stack
        while (!operators.isEmpty()) {
            double b = operands.pop();
            double a = operands.pop();
            char operator = operators.pop();
            double result = applyOperator(a, b, operator);
            operands.push(result);
        }

        // The final result is the top value on the operand stack
        return operands.pop();
    }

    // Helper function to apply an operator to two operands
    private double applyOperator(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    // Helper function to check if a character is an operator
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Helper function to get the precedence of an operator
    private int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else {
            return 0;
        }
    }








}