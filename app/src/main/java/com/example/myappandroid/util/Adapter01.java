package com.example.myappandroid.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myappandroid.Model.Product;
import com.example.myappandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class Adapter01 extends PagerAdapter {
    private List<Product> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter01(List<Product> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = layoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item01, container, false);
        ImageView imageView;
        TextView name, priceNew, priceOld, sale, rating;
        imageView = view.findViewById(R.id.image001);
        name = view.findViewById(R.id.name01);
        priceNew = view.findViewById(R.id.price_new01);
        priceOld = view.findViewById(R.id.price_old01);
        sale = view.findViewById(R.id.sale01);
        rating = view.findViewById(R.id.rating01);
        Picasso.get().load(models.get(position).getUrlImage()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(imageView);
        name.setText(models.get(position).getName());
        priceNew.setText(computePrice(models.get(position).getPrice(), models.get(position).getSale()));
        priceOld.setText(parseString(models.get(position).getPrice()));
        sale.setText("GIẢM " + String.valueOf(models.get(position).getSale()) + " %");
        rating.setText(String.valueOf(models.get(position).getRating()) + "/5");
        container.addView(view, 0);
        return view;
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

    private String computePrice(int priceOld, int sale) {
        int price = priceOld - (priceOld * sale / 100);
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
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
