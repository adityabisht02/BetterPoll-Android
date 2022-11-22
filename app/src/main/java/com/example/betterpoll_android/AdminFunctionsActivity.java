package com.example.betterpoll_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminFunctionsActivity extends AppCompatActivity {


    Button addUserBtn, messSettingsBtn, addShuttlesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_functions);

        addUserBtn = findViewById(R.id.btnSettingsEditMenu);
        messSettingsBtn = findViewById(R.id.btnSettingsMessCode);
        addShuttlesBtn = findViewById(R.id.btnSettingsAddShuttles);


        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminFunctionsActivity.this, AdminAddUserActivity.class);
                startActivity(intent);

            }
        });

        addShuttlesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminFunctionsActivity.this, AdminAddShuttleActivity.class);
                startActivity(intent);

            }
        });

        messSettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminFunctionsActivity.this, AdminMessSettingsActivity.class);
                startActivity(intent);
                Toast.makeText(AdminFunctionsActivity.this, "Butto clocked", Toast.LENGTH_LONG).show();

            }
        });
    }
}




