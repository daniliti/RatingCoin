package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class rega_stud extends AppCompatActivity implements View.OnClickListener {

    private Button back_rega_stud;
    private FirebaseAuth mAuth;
    private EditText editTextname, editTextage, editTextemail, editTextpassword;
    private ProgressBar progressBar2;
    private TextView registerUser;
    private Uri uploadUri;
    private EditText EdOtName;
    private EditText EdSecName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rega_stud);

        mAuth = FirebaseAuth.getInstance();

        registerUser = (Button) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);

        editTextname = (EditText) findViewById(R.id.name);
        editTextage = (EditText) findViewById(R.id.age);
        editTextemail = (EditText) findViewById(R.id.email);
        editTextpassword = (EditText) findViewById(R.id.password);

        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);

        back_rega_stud = (Button) findViewById(R.id.back_rega_stud);
        back_rega_stud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudent();
            }
        });

    }

    private void openStudent() {
        Intent intent = new Intent(this, Student.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerUser:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String email = editTextemail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();
        String name = editTextname.getText().toString().trim();
        String age = editTextage.getText().toString().trim();
        String otname = EdOtName.getText().toString().trim();
        String secname = EdSecName.getText().toString().trim();


        if (name.isEmpty()) {
            editTextname.setError("Обезятельное поле!");
            editTextname.requestFocus();
            return;
        }

        if (age.isEmpty()) {
            editTextage.setError("Обезятельное поле!");
            editTextage.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editTextemail.setError("Обезятельное поле!");
            editTextemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Пожалуйста введите правильнай адрес!");
            editTextemail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextpassword.setError("Обезятельное поле!");
            editTextpassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextpassword.setError("Минимальный символ 6");
            editTextpassword.requestFocus();
            return;
        }


        progressBar2.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            String id;
                            user user = new user(name, age, email);

                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()){
                                        Toast.makeText(rega_stud.this, "User has been", Toast.LENGTH_LONG).show();
                                        progressBar2.setVisibility(View.VISIBLE);


                                        //startActivity(new Intent(rega_stud.this, Student.class));

                                    }

                                    else {
                                        Toast.makeText(rega_stud.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                                        progressBar2.setVisibility(View.GONE);
                                    }

                                }
                            });

                        }else {
                            Toast.makeText(rega_stud.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                            progressBar2.setVisibility(View.GONE);
                        }

                    }
                });


    }

}