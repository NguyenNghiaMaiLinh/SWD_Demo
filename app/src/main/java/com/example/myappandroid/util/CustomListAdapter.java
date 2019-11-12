package com.example.myappandroid.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myappandroid.Model.Product;
import com.example.myappandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private List<Product> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(List<Product
            > list, Context context) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_layout, null);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.image_flag);
            holder.name = (TextView) convertView.findViewById(R.id.name_flag);
            holder.price = (TextView) convertView.findViewById(R.id.price_flag);
            holder.desc = (TextView) convertView.findViewById(R.id.desc_flag);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = this.list.get(i);
        holder.name.setText(product.getName());
        holder.price.setText(String.valueOf(((Product) product).getPrice()));
        holder.desc.setText(String.valueOf(((Product) product).getDescription()));
        Picasso.get().load(product.getUrlImage()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(holder.image);
        return convertView;
    }

    static class ViewHolder {
        ImageView image;
        TextView name;
        TextView price;
        TextView desc;
    }
}
