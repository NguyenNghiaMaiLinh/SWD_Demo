package com.example.myappandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.myappandroid.Model.Product;
import com.example.myappandroid.util.Adapter01;
import com.example.myappandroid.util.ViewPagerAdapterBanner;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ViewPager pitureBanner;
    ViewPager viewPager01;
    Adapter01 adapter01;
    List<Product> model01;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pitureBanner = findViewById(R.id.pitureBanner);
        Timer timer = new Timer();
        ViewPagerAdapterBanner viewPagerAdapter = new ViewPagerAdapterBanner(this);
        timer.scheduleAtFixedRate(new MyTimerTask(), 600, 4000);
        pitureBanner.setAdapter(viewPagerAdapter);

        model01 = new ArrayList<>();
        model01.add(new Product("01", "http://www.nhaxinh.com/photo/500-san-pham-nha-xinh_(26).jpg", "Bàn", 13900000, 4.5, 10, "Từ Hàn Quốc"));
        model01.add(new Product("02", "http://www.nhaxinh.com/photo/500-san-pham-nha-xinh_(26).jpg", "Bàn", 13900000, 3.5, 6, "Từ Hàn Quốc"));
        model01.add(new Product("04", "http://www.nhaxinh.com/photo/500-san-pham-nha-xinh_(26).jpg", "Bàn", 13900000, 3, 4, "Từ Hàn Quốc"));
        model01.add(new Product("05", "http://www.nhaxinh.com/photo/500-san-pham-nha-xinh_(26).jpg", "Bàn", 13900000, 3, 15, "Từ Hàn Quốc"));
        adapter01 = new Adapter01(model01, this);
        viewPager01 = findViewById(R.id.viewPager01);
        viewPager01.setAdapter(adapter01);
        viewPager01.setPadding(10, 0, 340, 0);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        break;
                    case R.id.nav_product:
                        startActivity(new Intent(getApplicationContext(), StoreActivity.class));
                        break;
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        break;
                }
                return true;
            }
        });
    }

    public void onClickDiscount(View v) {
        startActivity(new Intent(this, DiscountActivity.class));
    }
    public void onClickOrder(View v) {
        startActivity(new Intent(this, OrderActivity.class));
    }

    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (pitureBanner.getCurrentItem() == 0) {
                        pitureBanner.setCurrentItem(1);
                    } else if (pitureBanner.getCurrentItem() == 1) {
                        pitureBanner.setCurrentItem(2);
                    } else if (pitureBanner.getCurrentItem() == 2) {
                        pitureBanner.setCurrentItem(3);
                    } else if (pitureBanner.getCurrentItem() == 3) {
                        pitureBanner.setCurrentItem(4);
                    } else if (pitureBanner.getCurrentItem() == 4) {
                        pitureBanner.setCurrentItem(5);
                    }
                }
            });
        }
    }
}
