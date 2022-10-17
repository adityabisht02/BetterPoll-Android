package com.example.betterpoll_android;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class adityaLoginActivity extends AppCompatActivity {

    EditText editTextUniversityName;
    EditText editTextUsername;
    EditText editTextPassword;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        editTextPassword=findViewById(R.id.password);
        editTextUniversityName=findViewById(R.id.university);
        editTextUsername=findViewById(R.id.username);
        loginbtn=findViewById(R.id.loginbtn);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something when the corky is clicked
                String username=editTextUsername.getText().toString();
                String password=editTextPassword.getText().toString();

                if(username.equals("aditya") && password.equals("aditya")){
                    Intent intent = new Intent(adityaLoginActivity.this, ShuttleServiceActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(adityaLoginActivity.this, "Authentication failed.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
