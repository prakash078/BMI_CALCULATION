package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText weight,height;
    TextView textView;
    Button button;
    Float aFloat, aFloat1,BMI;
    Model model=new Model();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        textView =findViewById(R.id.displayresult);
        button =findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                model.setWeight(weight.getText().toString());
                model.setHeight(height.getText().toString());
                aFloat =Float.parseFloat(weight.getText().toString());
                aFloat1 =Float.parseFloat(height.getText().toString());
                aFloat1 = aFloat1 /100;
                BMI= aFloat /(aFloat1 * aFloat1);
                textView.setText(BMI.toString());

                if(BMI<18.5)
                {
                    Toast.makeText(MainActivity.this, "You are underweight.", Toast.LENGTH_SHORT).show();
                }
                else if(BMI>=18.5 && BMI<=24.9)
                {
                    Toast.makeText(MainActivity.this, "You have normal weight", Toast.LENGTH_SHORT).show();
                }
                else if(BMI==25 || BMI<=29.9)
                {
                    Toast.makeText(MainActivity.this, "You are overweight", Toast.LENGTH_SHORT).show();
                }
                else if(BMI>30)
                {
                    Toast.makeText(MainActivity.this, "You have serious obesity problem", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

