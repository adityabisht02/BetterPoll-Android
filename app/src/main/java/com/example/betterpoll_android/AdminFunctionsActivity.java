package com.example.betterpoll_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.example.betterpoll_android.databinding.ActivityMainBinding;
public class AdminFunctionsActivity extends AppCompatActivity {


    Button addUserBtn, editMessMenuBtn, addShuttlesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_functions);

        addUserBtn = findViewById(R.id.btnAddUsers);
        editMessMenuBtn = findViewById(R.id.btnmesssettings);
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

        editMessMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminFunctionsActivity.this, AdminEditMessMenuActivity.class);
                startActivity(intent);

            }
        });
    }
}




