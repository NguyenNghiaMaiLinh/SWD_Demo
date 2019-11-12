package com.example.myappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

public class SearchActivity extends AppCompatActivity {
    private AutoCompleteTextView txtSearch;
    private ListView viewSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        txtSearch = findViewById(R.id.txtSearch);
        viewSearch = findViewById(R.id.viewSearch);
    }
}
