package com.example.betterpoll_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class PreLoaderScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_loader_screen);

        askForFullScreen();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(PreLoaderScreen.this,LoginActivity.class);
                startActivity(intent);
                finish();



            }
        },2500);
        ImageView backgroundImg = (ImageView) findViewById(R.id.logoSplash);
        backgroundImg.setBackgroundColor(Color.rgb(255, 255, 255));

    }
   private void askForFullScreen() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        |View.SYSTEM_UI_FLAG_IMMERSIVE
                        |View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
    }


}