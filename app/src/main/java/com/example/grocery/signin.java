package com.example.grocery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.squareup.okhttp.Request;

import java.time.Instant;


public class signin extends AppCompatActivity {
    private TextView userRegistration;
    private Button btnLogin;
    private EditText Email,Password;
    private FirebaseAuth mauth;
    private String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        //setviews();
        Email=(EditText)findViewById(R.id.etemail);
        Password=(EditText)findViewById(R.id.etpassword);

        mauth = FirebaseAuth.getInstance();
        btnLogin = findViewById(R.id.button3);

        userRegistration=(TextView)findViewById(R.id.tvSignup);
        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signin.this,Signup.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = Email.getText().toString();
                password = Password.getText().toString();
                if(TextUtils.isEmpty(email))
                {
                    Email.requestFocus();
                    Email.setError("Please enter email");
                }
                else if (TextUtils.isEmpty(password))
                {
                    Password.requestFocus();
                    Password.setError("Please enter password");
                }
                else {
                    allowUserToSignIn();
                }
            }
        });

    }

    //private void setviews(){

    //}

    private void allowUserToSignIn() {

        mauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent mainIntent = new Intent(signin.this,HomePage.class);
                    startActivity(mainIntent);
                    finish();
                }
                else {
                    //String message = task.getException().getMessage();
                    Toast.makeText(signin.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    /*mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(this,OnCompleteListener { task ->
        if(task.isSuccessful) {
            Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(signin.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    });*/

}
