package com.example.myappandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myappandroid.Model.Discount;
import com.example.myappandroid.Model.Order;
import com.example.myappandroid.util.DiscountListAdapter;
import com.example.myappandroid.util.OrderListAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {
    BottomNavigationView bottomNavigationView;
    private final List<Order> list = new ArrayList<Order>();
    private OrderListAdapter adapter;
    private ListView listView;
    private TextView orderTotalQuantity;
    private TextView orderTotalPrice;
    private int quantity = 0;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        listView = findViewById(R.id.listViewOrder);
        orderTotalPrice = findViewById(R.id.orderTotalPrice);
        orderTotalQuantity = findViewById(R.id.orderTotalQuantity);

        list.clear();
        list.add(new Order("01", 19000000, 10, "GHẾ LÀM VIỆC SKAGEN", 1, "http://www.nhaxinh.com/photo/3_91314-ghe-lam-viec-skagen_-_copy.png", "Công ty Tân Tạo"));
        list.add(new Order("02", 12000000, 0, "Ghế Văn Phòng Chân Xoay BG", 2, "https://salt.tikicdn.com/cache/200x200/ts/product/20/29/50/c93be0437a6fba102ca6a23d845dce2f.jpg", "Công ty Hai Lúa"));
        list.add(new Order("02", 12000000, 0, "Ghế Văn Phòng Chân Xoay BG", 2, "https://salt.tikicdn.com/cache/200x200/ts/product/20/29/50/c93be0437a6fba102ca6a23d845dce2f.jpg", "Công ty Hai Lúa"));
        list.add(new Order("02", 12000000, 0, "Ghế Văn Phòng Chân Xoay BG", 2, "https://salt.tikicdn.com/cache/200x200/ts/product/20/29/50/c93be0437a6fba102ca6a23d845dce2f.jpg", "Công ty Hai Lúa"));
        for (int i = 0; i < list.size(); i++) {
            quantity += list.get(i).getQuantity();
            total += (list.get(i).getPrice() - (list.get(i).getPrice() * list.get(i).getSale()) / 100)*list.get(i).getQuantity();
        }
        orderTotalPrice.setText(parseString(total));
        orderTotalQuantity.setText("("+String.valueOf(quantity)+")");
        adapter = new OrderListAdapter(list, getApplicationContext());
        listView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarOrder);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }

    private String parseString(int price) {
        String formatted_value = "";

        while (price > 999) {
            int temp = price % 1000;
            price = price / 1000;
            formatted_value = String.format(Locale.getDefault(), ".%,03d", temp) + formatted_value;
        }
        String s = String.valueOf(price);
        formatted_value = s + formatted_value;
        return String.format(Locale.getDefault(), "%s đ", formatted_value);
    }
    @Override
    public void onClick(View v) {

    }
}
