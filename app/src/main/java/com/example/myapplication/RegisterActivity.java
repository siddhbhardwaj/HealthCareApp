package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername, edPassword, edEmail, edConfirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn = findViewById(R.id.buttonBookAppointment);
        edUsername = findViewById(R.id.editTextAppFullName);
        edPassword = findViewById(R.id.editTextAppContactNumber);
        tv = findViewById(R.id.textViewExistingUser);
        edEmail = findViewById(R.id.editTextAppAdress);
        edConfirm =findViewById(R.id.editTextAppFees);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                String email = edEmail.getText().toString();
                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                if(username.length()==0 || password.length()==0 || confirm.length()==0 || email.length()==0){
                    Toast.makeText(getApplicationContext(),"Please Fill Details",Toast.LENGTH_SHORT).show();

                }else{
                    if(password.compareTo(confirm)==0){
                        db.register(username,email,password);
                        Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));



                    }else{
                        Toast.makeText(getApplicationContext(),"Passwords don't match",Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });


    }
}