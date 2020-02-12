package com.example.leetaifkapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup_g extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText editText4, editText8, editText9, editText7, editText10, editText14, editText15;
    Button button;
    TextView textView6,textView7, textView8, textView9, button3;
    Spinner spinner;
    RadioButton radioButton2, radioButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_g);

        editText4 = findViewById(R.id.usernameg );
        editText8 = findViewById(R.id.fnameg );
        editText9 = findViewById(R.id.lnameg );
        editText7 = findViewById(R.id.emailg );
        editText10 = findViewById(R.id.passwordg );
        editText14 = findViewById(R.id.relationg );
        editText15 = findViewById(R.id.phoneg );
        textView6 = findViewById(R.id.signup_page );
        textView7 = findViewById(R.id.genderg );
        textView8 = findViewById(R.id.relationg );
        textView9 = findViewById(R.id.cityg );
        spinner = findViewById(R.id.spinner);
        radioButton2 = findViewById(R.id.radioButton_female );
        radioButton4 = findViewById(R.id.radioButton_male );
        button = findViewById(R.id.buttonnext );
        button3 = findViewById(R.id.buttonlogin );


        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish(); }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username_g = editText4.getText().toString().trim();
                final String firstname_g = editText8.getText().toString().trim();
                final String lasttname_g = editText9.getText().toString().trim();
                final String email_g = editText7.getText().toString().trim();
                String password_g = editText10.getText().toString().trim();
                final String relation_g = editText14.getText().toString();
                final String phone_g = editText15.getText().toString();

                if(TextUtils.isEmpty(username_g)){
                    editText4.setError("Password is Required.");
                    return;
                }

                if(TextUtils.isEmpty(firstname_g)){
                    editText8.setError("Password is Required.");
                    return;
                }

                if(TextUtils.isEmpty(lasttname_g)){
                    editText9.setError("Password is Required.");
                    return;
                }

                if(TextUtils.isEmpty(email_g)){
                    editText7.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password_g)){
                    editText10.setError("Password is Required.");
                    return;
                }

                if(TextUtils.isEmpty(relation_g)){
                    editText14.setError("Password is Required.");
                    return;
                }

                if(TextUtils.isEmpty(phone_g)){
                    editText15.setError("Password is Required.");
                    return;
                }

                // register the user in firebase

                mAuth.createUserWithEmailAndPassword(email_g,password_g ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(signup_g.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else {
                            Toast.makeText(signup_g.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            //progressBar.setVisibility(View.GONE);
                        }
                    }
                });

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),login_g.class));
                    }
                });



            }


        });




    }}
