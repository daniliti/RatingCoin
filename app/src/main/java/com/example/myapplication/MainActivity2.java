package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {

    private Button back_btn;
    private Button stud_btn;
    private Button sot_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        back_btn = (Button) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        stud_btn = (Button) findViewById(R.id.stud_btn);
        stud_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudent();
            }
        });

        sot_btn = (Button) findViewById(R.id.sot_btn);
        sot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSotrudnik();
            }
        });
      // Write a message to the database
      FirebaseDatabase database = FirebaseDatabase.getInstance();
      DatabaseReference myRef = database.getReference("message");

      myRef.setValue("Hello, World!");

    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openStudent() {
        Intent intent = new Intent(this, Student.class);
        startActivity(intent);
    }

    private void openSotrudnik() {
        Intent intent = new Intent(this, Sotrudnik.class);
        startActivity(intent);
    }

}
