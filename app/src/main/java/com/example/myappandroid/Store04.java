package com.example.myappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Store04 extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_store_04, null, false);
        CardView cardView = root.findViewById(R.id.storeItem04);

        cardView.setOnClickListener(this);

        Intent intent = getActivity().getIntent();
        if (Boolean.parseBoolean(intent.getStringExtra("isDel")) == true) {
            cardView.setVisibility(View.GONE);
        }
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.storeItem04:
                startActivity(new Intent(getContext(), MainActivity.class));
                break;
        }
    }
}