package com.example.grocery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    private EditText username,userpassword,useremail;
    private Button Signup;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setupViews();
        firebaseAuth = FirebaseAuth.getInstance();
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validate()) {
                    //upload to database
                    String user_name = username.getText().toString().trim();
                    String user_email = useremail.getText().toString().trim();
                    String user_password = userpassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Signup.this, "SignUp Successfull", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Signup.this, "Unsuccessfull", Toast.LENGTH_SHORT).show();
                            }
                        }

                        ;
                    });
                }}
            });
    }
    private void setupViews(){
        username=(EditText)findViewById(R.id.etusername);
        useremail=(EditText)findViewById(R.id.etuseremail);
        userpassword=(EditText)findViewById(R.id.etuserpassword);
        Signup=(Button)findViewById(R.id.btnSignup);
    }
    private boolean Validate(){
        boolean result=false;
        String name=username.getText().toString();
        String email=useremail.getText().toString();
        String password=userpassword.getText().toString();
        if(name.isEmpty() || email.isEmpty() || password.isEmpty())
            Toast.makeText(this,"Please enter all the details",Toast.LENGTH_SHORT).show();
        else
            result=true;
        return result;
    }
}
