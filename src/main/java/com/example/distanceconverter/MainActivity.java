package com.example.distanceconverter;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText km,m,miles;
    Button clear,convert;

    //2 decimal format
    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        km = findViewById(R.id.km);
        m = findViewById(R.id.m);
        miles = findViewById(R.id.miles);
        clear = findViewById(R.id.clear);
        convert = findViewById(R.id.convert);

        //function for convert button to operate
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String kilometre = km.getText().toString();
                final String metre = m.getText().toString();
                final String mile = miles.getText().toString();

                double valueKM,valueMetre,valueMile;

               //to calculate km
                if (metre.equals("")&& mile.equals("")){
                    valueKM = Double.parseDouble(kilometre);
                    valueMetre = valueKM * 1000;
                    valueMile = valueKM * 0.621371;

                    String totalValueMetre = decimalFormat.format(valueMetre);
                    String totalValueMile = decimalFormat.format(valueMile);

                    m.setText(totalValueMetre);
                    miles.setText(totalValueMile);
                }

                //to calculate m
                else if (kilometre.equals("")&& mile.equals("")){

                    valueMetre = Double.parseDouble(metre);
                    valueKM = valueMetre * 0.001;
                    valueMile = valueMetre * 0.000621371;

                    String totalValueMile = decimalFormat.format(valueMile);
                    String totalValueKM = decimalFormat.format(valueKM);

                    km.setText(totalValueKM);
                    miles.setText(totalValueMile);
                }

                //to calculate miles
                else if (kilometre.equals("") && metre.equals("")){

                    valueMile = Double.parseDouble(mile);
                    valueKM = valueMile * 1.60934;
                    valueMetre = valueMile * 1609.34;

                    String totalValueKM = decimalFormat.format(valueKM);
                    String totalValueMetre = decimalFormat.format(valueMetre);

                    km.setText(totalValueKM);
                    m.setText(totalValueMetre);
                }

                Toast.makeText(getApplicationContext(),"Convertion Successful", Toast.LENGTH_LONG).show();
            }
        });

        //clear button function
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                km.setText("");
                m.setText("");
                miles.setText("");

                Toast.makeText(getApplicationContext(),"Cleared Successful", Toast.LENGTH_LONG).show();
            }
        });


    }
}
