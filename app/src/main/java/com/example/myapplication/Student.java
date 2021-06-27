package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Student extends AppCompatActivity implements View.OnClickListener {
    private Button back_btn1;
    private Button rega_stud;
    private Button signIn;
    private EditText EditTextEmail, EditTextPassword;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        back_btn1 = (Button) findViewById(R.id.back_btn1);
        back_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity2();
            }
        });

        rega_stud = (Button) findViewById(R.id.rega_stud);
        rega_stud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegaStud();
            }
        });


        signIn = (Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(this);

        EditTextEmail = (EditText) findViewById(R.id.EditTextEmail);
        EditTextPassword = (EditText) findViewById(R.id.EditEextPassword);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();




    }


    private void openMainActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    private void openRegaStud() {
        Intent intent = new Intent(this, rega_stud.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signIn:
                userlogin();
                break;

        }
    }

    private void userlogin() {
        String email = EditTextEmail.getText().toString().trim();
        String passowrd = EditTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            EditTextEmail.setError("Email is required!");
            EditTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            EditTextEmail.setError("Please enter a valid email!");
            EditTextEmail.requestFocus();
            return;
        }

        if (passowrd.isEmpty()) {
            EditTextPassword.setError("Password is required!");
            EditTextPassword.requestFocus();
            return;
        }

        if (passowrd.length() < 6) {
            EditTextPassword.setError("Min passoword lenght is 6 characters!");
            EditTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, passowrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    startActivity(new Intent(Student.this, PersonalArea.class));

                }else{
                    Toast.makeText(Student.this, "Failed to login! Please chek your credentials", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}