package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ObActivity extends AppCompatActivity {
    ImageButton imgbtn1;
    Button btncreate, main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ob);

        imgbtn1 = (ImageButton) findViewById(R.id.imgbtn1);
        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadMaxActivity= new Intent(ObActivity.this,MaxActivity.class);
                startActivity(intentLoadMaxActivity);
            }
        });

        btncreate = (Button) findViewById(R.id.btncreate);
        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switcher = new Intent(ObActivity.this, creat.class);
                ObActivity.this.startActivity(switcher);
            }

        });

        main = (Button) findViewById(R.id.button5);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ObActivity.this, MainActivity3.class);
                startActivity(i);
            }
        });
}}