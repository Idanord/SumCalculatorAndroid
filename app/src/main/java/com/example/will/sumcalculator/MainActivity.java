package com.example.will.sumcalculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

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

    public static final String EXTRA_MESSAGE = "com.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to widgets
        editTextNum1 = (EditText) findViewById(R.id.editTextNum1);
        editTextNum2 = (EditText) findViewById(R.id.editTextNum2);
        buttonGetSum = (Button) findViewById(R.id.buttonGetSum);
        //textViewAnswer = (TextView) findViewById(R.id.textViewAnswer);

        //set the listener
        //buttonGetSum.setOnClickListener((View.OnClickListener) this);

        //get shared prefs object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    /**public void caluculateAndDisplay(){
        num1 = Integer.parseInt(editTextNum1.getText().toString());
        num2 = Integer.parseInt(editTextNum2.getText().toString());
        int sum = num1 + num2;

        textViewAnswer.setText(String.valueOf(sum));

    }**/

    /** Called when the user taps the button for Sum **/
    public void sendMessage(View v){
        //send an intent that you are going to invoke the second activity from the first activity
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        //get values for the numbers to be added
        num1 = Integer.parseInt(editTextNum1.getText().toString());
        num2 = Integer.parseInt(editTextNum2.getText().toString());

        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);

        startActivity(intent);

    }

    /**@Override
    public void onClick(View v) {
        caluculateAndDisplay();
    }**/

    @Override
    public void onPause(){

        //save the instance variables
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putInt("num1", num1);
        editor.putInt("num2", num2);
        editor.commit();
        super.onPause();
    }

    @Override
    public void onResume(){

        //resume the instance variables
        super.onResume();
        num1 = savedValues.getInt("num1", 0);
        num2 = savedValues.getInt("num2", 0);
    }
}
