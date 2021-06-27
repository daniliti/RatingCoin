package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity3 extends AppCompatActivity {

    private ImageButton rasp, ob;
    private Button prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rasp = (ImageButton) findViewById(R.id.imageButton3);
        rasp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity3.this, Spisok.class);
                startActivity(i);
            }
        });

        ob = (ImageButton) findViewById(R.id.imageButton2);
        ob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity3.this, ObActivity.class);
                startActivity(i);
            }
        });

        prof = (Button) findViewById(R.id.button3);
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity3.this, PersonalArea.class);
                startActivity(i);
            }
        });


    }
}