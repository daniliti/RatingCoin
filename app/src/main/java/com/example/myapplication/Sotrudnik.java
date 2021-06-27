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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sotrudnik extends AppCompatActivity implements View.OnClickListener {

    private Button back_btn2, next_btn1, rega_sot;
    private EditText EditEmail, EditPassword;
    private ProgressBar progressBar3;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sotrudnik);

        back_btn2 = (Button) findViewById(R.id.back_btn2);
        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity2();
            }
        });

        rega_sot = (Button) findViewById(R.id.rega_sot);
        rega_sot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegaStud();
            }
        });

        next_btn1 = (Button) findViewById(R.id.next_btn1);
        next_btn1.setOnClickListener(this);

        EditEmail = (EditText) findViewById(R.id.EditEmail);
        EditPassword = (EditText) findViewById(R.id.EditPassowrd);

        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);

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
            case R.id.next_btn1:
                userlogin();
                break;

        }
    }

    private void userlogin() {

        String email = EditEmail.getText().toString().trim();
        String passowrd = EditPassword.getText().toString().trim();

        if (email.isEmpty()) {
            EditEmail.setError("Email is required!");
            EditEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            EditEmail.setError("Please enter a valid email!");
            EditEmail.requestFocus();
            return;
        }

        if (passowrd.isEmpty()) {
            EditPassword.setError("Password is required!");
            EditPassword.requestFocus();
            return;
        }

        if (passowrd.length() < 6) {
            EditPassword.setError("Min passoword lenght is 6 characters!");
            EditPassword.requestFocus();
            return;
        }

        progressBar3.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, passowrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    startActivity(new Intent(Sotrudnik.this, PersonalArea.class));

                }else{
                    Toast.makeText(Sotrudnik.this, "Failed to login! Please chek your credentials", Toast.LENGTH_LONG).show();
                    // jcenter() // Warning: this repository is going to shut down soon
                }

            }
        });

    }
}
