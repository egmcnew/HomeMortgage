package com.example.homemortgage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    float decPayment;
    int intYears;
    int intPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText monthlyPayment = (EditText) findViewById(R.id.input1);
        final EditText numYears = (EditText) findViewById(R.id.input2);
        final EditText principal = (EditText) findViewById(R.id.input3);
        Button button = (Button)findViewById(R.id.but1);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decPayment = Float.parseFloat(monthlyPayment.getText().toString());
                intYears = Integer.parseInt(numYears.getText().toString());
                intPrincipal = Integer.parseInt(principal.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", decPayment);
                editor.putInt("key2", intYears);
                editor.putInt("key3", intPrincipal);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Interest.class));
            }
        });
    }
}
