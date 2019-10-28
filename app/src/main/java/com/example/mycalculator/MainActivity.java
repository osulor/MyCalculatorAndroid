package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int DIVIDE = 0;
    private final int ADD  =  1;
    private final int SUBSTRACT = 2;
    private final int MULTIPLY = 3;
    private final int REMAINDER = 4;
    private final int SINUS = 5;
    private final int COSINUS = 6;
    private final int SQUAREROOT = 7;
    private final int TAN = 8;

    private TextView answerTextView;
    private Float answerValue = 0.0f;
    private Float firstValue = 0.0f;
    private Float secondValue = 0.0f;
    private int operator = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerTextView = findViewById(R.id.main_textView);
    }

    private void clearTextField(){
        answerTextView.setText("0");
        firstValue = 0f;
        secondValue = 0f;
        operator = 0;
        answerValue = 0f;
    }

    private void setOperator(int operator){

        this.operator = operator;
        firstValue = Float.parseFloat(answerTextView.getText().toString());

        answerTextView.setText("0");

    }



    private void calculate(){

        secondValue = Float.parseFloat(answerTextView.getText().toString());


        switch (operator){

            case ADD:
                answerValue = firstValue + secondValue;
                break;

            case MULTIPLY:
                answerValue = firstValue * secondValue;
                break;

            case DIVIDE:
                answerValue = firstValue / secondValue;
                break;

            case SUBSTRACT:
                answerValue = firstValue - secondValue;
                break;

            case REMAINDER:
                 answerValue = firstValue % secondValue;
                break;

            case SINUS:
                 answerValue =(float) Math.sin(Math.toRadians(secondValue));
                break;

            case COSINUS:
                answerValue = (float) Math.cos(Math.toRadians(secondValue));
                break;

            case TAN:
                answerValue = (float) Math.tan(Math.toRadians(secondValue));
                break;

            case SQUAREROOT:
                answerValue = (float) Math.sqrt(secondValue);
                break;
        }

        answerTextView.setText(answerValue.toString());

    }


    private void addNumber(int value){
        if(answerTextView.getText().equals("0")){
            answerTextView.setText("");
        }

        answerTextView.setText(answerTextView.getText().toString() + value);
    }

    private void removeNumber(){
        if(answerTextView.getText().toString().trim().length() > 0 && !answerTextView.getText().toString().equals("0"))
            answerTextView.setText(answerTextView.getText().toString().substring(0, answerTextView.length()-1));
    }

    public void onClick(View view){
        switch(view.getId()){

            case R.id.add_button:
                setOperator(ADD);
                break;


            case R.id.back_button:
                removeNumber();
                break;


            case R.id.clear_button:
                clearTextField();
                break;


            case R.id.division_button:
                setOperator(DIVIDE);
                break;

            case R.id.squareRoot_button:
                setOperator(SQUAREROOT);
                break;

            case R.id.sin_button:

                setOperator(SINUS);

                break;

            case R.id.cos_button:
                setOperator(COSINUS);
                break;

            case R.id.tan_button:
                setOperator(TAN);

                break;


            case R.id.dot_button:
                break;


            case R.id.eight_button:
                addNumber(8);
                break;


            case R.id.equal_button:
                calculate();
                break;


            case R.id.five_button:
                addNumber(5);
                break;


            case R.id.four_button:
                addNumber(4);
                break;


            case R.id.minus_button:
                setOperator(SUBSTRACT);
                break;

            case R.id.remainder_button:
                setOperator(REMAINDER);
                break;


            case R.id.multiply_button:
                setOperator(MULTIPLY);
                Log.d("remind", "onClick() returned: " + "*" );
                break;


            case R.id.nine_button:
                addNumber(9);
                break;


            case R.id.one_button:
                addNumber(1);
                break;


            case R.id.seven_button:
                addNumber(7);
                break;


            case R.id.six_button:
                addNumber(6);
                break;


            case R.id.three_button:
                addNumber(3);
                break;

            case R.id.two_button:
                addNumber(2);
                break;

            case R.id.zero_button:
                addNumber(0);
                break;

        }


    }
}
