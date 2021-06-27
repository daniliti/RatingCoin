package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Spisok extends AppCompatActivity {

    Button i_21;
    Button o_21;
    Button t_21;
    Button i_20;
    Button o_20;
    Button t_20;
    Button i_19;
    Button o_19;
    Button back;
    Button logo;
    Button lk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spisok);
         i_21 = (Button) findViewById(R.id.i_21);
         o_21 = (Button) findViewById(R.id.o_21);
         t_21 = (Button) findViewById(R.id.t_21);
         i_20 = (Button) findViewById(R.id.i_20);
         o_20 = (Button) findViewById(R.id.o_20);
         t_20 = (Button) findViewById(R.id.t_20);
         i_19 = (Button) findViewById(R.id.i_19);
         o_19 = (Button) findViewById(R.id.o_19);
         lk = (Button) findViewById(R.id.lk);
         back = (Button) findViewById(R.id.back);

        i_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Spisok.this, i_21.class);
                startActivity(i);
                finish();
            }
        });
        o_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Spisok.this, o_21.class);
                startActivity(i);
                finish();

            }
        });
        t_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Spisok.this, t_21.class);
                startActivity(i);
                finish();
            }
        });
        i_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Spisok.this, i_20.class);
                startActivity(i);
                finish();
            }
        });
        o_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Spisok.this, o_20.class);
                startActivity(i);
                finish();
            }
        });
        t_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Spisok.this, t_20.class);
                startActivity(i);
                finish();
            }
        });
        i_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Spisok.this, i_19.class);
                startActivity(i);
                finish();
            }
        });
        o_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Spisok.this, o_19.class);
                startActivity(i);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Spisok.this, MainActivity3.class);
                startActivity(i);
                finish();
            }
        });

        lk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Spisok.this, PersonalArea.class);
                startActivity(i);
            }
        });

    }
}
