package com.example.betterpoll_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.example.betterpoll_android.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView=findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(navView, navController);











        //setContentView(R.layout.activity_main);

        //bottomBar=findViewById(R.id.bottomNavigationView);

        // Create new fragment and transaction
       // FragmentManager fragmentManager =getSupportFragmentManager();


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