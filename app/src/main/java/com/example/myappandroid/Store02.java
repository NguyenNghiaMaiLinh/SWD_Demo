package com.example.myappandroid;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Store02 extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_store_02, null, false);
        CardView cardView = root.findViewById(R.id.storeItem02);

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

            case R.id.storeItem02:
                startActivity(new Intent(getContext(), MainActivity.class));
                break;
        }
    }
}