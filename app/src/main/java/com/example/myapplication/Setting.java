package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Setting extends AppCompatActivity {

    private EditText EdName, EdSecName, EdOtName;
    private DatabaseReference mDataBase;
    private String USER_KEY = "users";
    private Button Save, back_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();

        Save = (Button) findViewById(R.id.Save);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSave();
            }
        });

        back_area = (Button) findViewById(R.id.back_area);
        back_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListView();
            }
        });

    }

    private void onClickSave() {

        String id = mDataBase.getKey();
        String name = EdName.getText().toString();
        String secname = EdSecName.getText().toString();
        String otname = EdOtName.getText().toString();

        user newuser = new  user (name, secname, otname);


        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(secname) && !TextUtils.isEmpty(otname)){
            mDataBase.push().setValue(newuser);
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
        }

    }

    private void init() {
        EdName = findViewById(R.id.EdName);
        EdSecName = findViewById(R.id.EdSecName);
        EdOtName = findViewById(R.id.EdOtName);

        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }

    private void onListView(){
        Intent i = new Intent(Setting.this, PersonalArea.class);
        startActivity(i);
    }


}