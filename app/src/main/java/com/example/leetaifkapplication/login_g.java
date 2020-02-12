package com.example.leetaifkapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_g extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText editText2, editText3;
    Button button2, button3;
    TextView textView2,textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_g);

        mAuth = FirebaseAuth.getInstance();
        editText2 = findViewById(R.id.emailg );
        editText3 = findViewById(R.id.passwordg );
        textView2 = findViewById(R.id.loging_page );
        textView = findViewById(R.id.have_account );
        button2 = findViewById(R.id.buttonnew_acc );
        button3 = findViewById(R.id.buttonlogin );


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username1 = editText2.getText().toString().trim();
                String password1 = editText3.getText().toString().trim();

                if(TextUtils.isEmpty(username1)){
                    editText2.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password1)){
                    editText3.setError("Password is Required.");
                    return;
                }

                if(password1.length() < 6){
                    editText3.setError("Password Must be >= 6 Characters");
                    return;
                }

                // register the user in firebase

                mAuth.signInWithEmailAndPassword(username1,password1 ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(login_g.this, "login succcessfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else {
                            Toast.makeText(login_g.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            //progressBar.setVisibility(View.GONE);
                        }
                    }







            });



                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),login_g.class));
                    }
                });









            }});}}
