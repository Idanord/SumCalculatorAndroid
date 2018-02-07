package com.example.will.sumcalculator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    //define instance variables
    private EditText editTextNum1;
    private EditText editTextNum2;
    private Button buttonGetSum;
    private TextView textViewAnswer;

    //define the shared pref object
    private SharedPreferences savedValues;

    //define the variables to be saved
    private int num1 = 0;
    private int num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to widgets
        editTextNum1 = (EditText) findViewById(R.id.editTextNum1);
        editTextNum2 = (EditText) findViewById(R.id.editTextNum2);
        buttonGetSum = (Button) findViewById(R.id.buttonGetSum);
        textViewAnswer = (TextView) findViewById(R.id.textViewAnswer);

        //set the listener
        buttonGetSum.setOnClickListener((View.OnClickListener) this);

        //get shared prefs object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    public void caluculateAndDisplay(){
        num1 = Integer.parseInt(editTextNum1.getText().toString());
        num2 = Integer.parseInt(editTextNum2.getText().toString());
        int sum = num1 + num2;

        textViewAnswer.setText(String.valueOf(sum));

    }

    @Override
    public void onClick(View v) {
        caluculateAndDisplay();
    }
}
