package com.example.betterpoll_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMessSettingsActivity extends AppCompatActivity {


    Button enterMessCodeBtn, editMessMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mess_settings);


        editMessMenuBtn = findViewById(R.id.btnSettingsEditMenu);
        enterMessCodeBtn = findViewById(R.id.btnSettingsMessCode);


        enterMessCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminMessSettingsActivity.this, AdminMessAttendanceActivity.class);
                startActivity(intent);

            }
        });

        editMessMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminMessSettingsActivity.this, AdminEditMessMenuActivity.class);
                startActivity(intent);

            }
        });

    }
}

