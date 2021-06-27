package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StasActivity extends AppCompatActivity {
    Button btnback;
    Button btnmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stas);

        btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switcher = new Intent(StasActivity.this, MaxActivity.class);
                StasActivity.this.startActivity(switcher);
            }

        });
        btnmain = (Button) findViewById(R.id.btnmain);
        btnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switcher = new Intent(StasActivity.this, ObActivity.class);
                StasActivity.this.startActivity(switcher);
            }

        });
    }
}