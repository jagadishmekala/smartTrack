package com.ags.loyalitymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashCourselActivity2 extends Activity {
    ViewPager viewPager;
    LinearLayout login_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_coursel2);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(SplashCourselActivity2.this,R.color.dark_blue_spl));
        }
        login_tv = findViewById(R.id.login_LL);
        viewPager = findViewById(R.id.viewPager);
        ImagePageAdapter adapter = new ImagePageAdapter(this);
        viewPager.setAdapter(adapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new AutoScrollTask(), 3000, 3000);
        login_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashCourselActivity2.this,LoginActivity.class));
            }
        });
    }

    private class AutoScrollTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(() -> {
                if (viewPager.getCurrentItem() < 2) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                } else {
                    viewPager.setCurrentItem(0);
                }
            });
        }
    }
    }
