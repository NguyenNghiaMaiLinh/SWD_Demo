package com.example.myappandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myappandroid.Model.Discount;
import com.example.myappandroid.Model.Product;
import com.example.myappandroid.util.CustomListAdapter;
import com.example.myappandroid.util.DiscountListAdapter;

import java.util.ArrayList;
import java.util.List;

public class DiscountActivity extends AppCompatActivity implements View.OnClickListener  {
    private final List<Discount> list = new ArrayList<Discount>();
    private DiscountListAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);

        listView = findViewById(R.id.listViewDiscount);
//        list.clear();
        list.add(new Discount("01", "Giảm 30% cho mặt hàng là ghế trong tháng 12","https://cdn.shopify.com/s/files/1/2655/9412/files/discount_30_large.jpg?v=1530713031","Not yet","1/12/2019","30/12/2019","GHNK083"));
        list.add(new  Discount("02", "Giảm 40% cho mặt hàng là ghế trong tháng 12","http://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/31332315/33ede365418579d6abf9f2a8bc42e5c60b80984d.jpg","Not yet","1/12/2019","30/12/2019","GHNK084"));

        adapter = new DiscountListAdapter(list,getApplicationContext());
        listView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarDiscount);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


        }
    }
}
