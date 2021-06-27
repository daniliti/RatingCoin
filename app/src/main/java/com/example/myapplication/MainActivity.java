package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button auto_btn;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auto_btn = (Button) findViewById(R.id.auto_btn);
       auto_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openMainActivity2();
            }
        });

       imageButton = (ImageButton) findViewById(R.id.imageButton);
       imageButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openImageButton();
           }
       });

    }

    private void openMainActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    private void openImageButton() {
        Intent browserIntent = new
                Intent(Intent.ACTION_VIEW, Uri.parse("http://college-pokrovsk.ru/"));
        startActivity(browserIntent);
    }

}