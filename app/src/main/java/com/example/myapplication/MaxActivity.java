package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MaxActivity extends AppCompatActivity {
    Button btndone;
    Button btnback2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max);

        btndone = (Button) findViewById(R.id.btndone);
        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switcher = new Intent(MaxActivity.this, StasActivity.class);
                MaxActivity.this.startActivity(switcher);
            }

        });
        btnback2 = (Button) findViewById(R.id.btnback2);
        btnback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switcher = new Intent(MaxActivity.this, ObActivity.class);
                MaxActivity.this.startActivity(switcher);
            }

        });
    }
}