package com.example.betterpoll_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminFunctionsActivity extends AppCompatActivity {


    Button addUserBtn, messSettingsBtn, addShuttlesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_functions);

        addUserBtn = findViewById(R.id.btnEditMenu);
        messSettingsBtn = findViewById(R.id.btnMessCode);
        addShuttlesBtn = findViewById(R.id.btnAddShuttles);


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

            }
        });
    }
}




