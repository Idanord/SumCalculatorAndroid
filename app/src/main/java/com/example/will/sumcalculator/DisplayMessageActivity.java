package com.example.will.sumcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

    //declare the instance variables
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //get ref to the widget
        textView = (TextView) findViewById(R.id.textView);

        //get values from the main activity
        Bundle bundle = getIntent().getExtras();

        int num1 = bundle.getInt("num1");
        int num2 = bundle.getInt("num2");

        //add the values
        int sum = num1 + num2;

        //output the sum
        textView.setText(Integer.toBinaryString(sum));
    }
}
