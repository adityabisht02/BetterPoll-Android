package com.example.betterpoll_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBar=findViewById(R.id.bottomNavigationView);

        // Create new fragment and transaction
        FragmentManager fragmentManager =getSupportFragmentManager();


        //Bottom bar fragment transition

//        bottomBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected( MenuItem item) {
//                switch(item.getItemId()){
//                    case R.id.alert:fragmentManager.beginTransaction()
//                            .setReorderingAllowed(true)
//                            .addToBackStack("name")
//                            .replace(R.id.fragmentContainerView, MealRemindersFragment.class, null)
//                            .commit();
//                    return true;
//
//                    case R.id.booking:
//
//                }
//                return false;
//            }
//        });

    }
}