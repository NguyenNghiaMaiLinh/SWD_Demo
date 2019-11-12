package com.example.myappandroid;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.myappandroid.MainActivity;
import com.example.myappandroid.Model.Product;
import com.example.myappandroid.R;
import com.example.myappandroid.util.CustomListAdapter;

import java.util.ArrayList;
import java.util.List;

public class Store01 extends Fragment implements View.OnClickListener {
    private final List<Product> list = new ArrayList<Product>();
    private CustomListAdapter adapter;
    private ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_store_01, null, false);
        listView = root.findViewById(R.id.listView1);
        list.clear();
        list.add(new  Product("01", "http://www.nhaxinh.com/photo/500-san-pham-nha-xinh_(26).jpg","Bàn",123,3,30,"Từ Hàn Quốc"));
        list.add(new  Product("02", "http://www.nhaxinh.com/photo/500-san-pham-nha-xinh_(26).jpg","Bàn",123,3,30,"Từ Hàn Quốc"));
        list.add(new  Product("03", "http://www.nhaxinh.com/photo/500-san-pham-nha-xinh_(26).jpg","Bàn",123,3,30,"Từ Hàn Quốc"));
        list.add(new  Product("03", "http://www.nhaxinh.com/photo/500-san-pham-nha-xinh_(26).jpg","Bàn",123,3,30,"Từ Hàn Quốc"));
        list.add(new  Product("03", "http://www.nhaxinh.com/photo/500-san-pham-nha-xinh_(26).jpg","Bàn",123,3,30,"Từ Hàn Quốc"));

        adapter = new CustomListAdapter(list,getActivity());
        listView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


        }
    }
}
