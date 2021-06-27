package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class creat extends AppCompatActivity {

    Button btnback3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat);
        btnback3 = (Button) findViewById(R.id.btnback3);
        btnback3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switcher = new Intent(creat.this, ObActivity.class);
                creat.this.startActivity(switcher);
            }

        });
    }
}