package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class i_19 extends AppCompatActivity {
    Button back2;
    ListView spi19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_19);
        Button back2 = findViewById(R.id.back2);
        ListView lvM = (ListView)findViewById(R.id.spi19);

        ArrayAdapter<CharSequence>  adapter = ArrayAdapter.createFromResource(this, R.array.sgi_19,
                android.R.layout.simple_list_item_1);
        lvM.setAdapter(adapter);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(i_19.this, Spisok.class);
                startActivity(i);
                finish();
            }
        });

        }

    }

