package com.example.myappandroid.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myappandroid.Model.Discount;
import com.example.myappandroid.Model.Product;
import com.example.myappandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DiscountListAdapter extends BaseAdapter {
    private List<Discount> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public DiscountListAdapter(List<Discount
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
            convertView = layoutInflater.inflate(R.layout.item_discount, null);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.discountimage);
            holder.title = (TextView) convertView.findViewById(R.id.txtdiscountname);
            holder.code = (TextView) convertView.findViewById(R.id.txtdiscountcode);
            holder.endDate = (TextView) convertView.findViewById(R.id.txtdiscountenddate);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Discount discount = this.list.get(i);
        holder.title.setText(discount.getTitle());
        holder.endDate.setText(String.valueOf(((Discount) discount).getEndAt()));
        holder.code.setText(discount.getCode());
        Picasso.get().load(discount.getUrlImage()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(holder.image);
        return convertView;
    }

    static class ViewHolder {
        ImageView image;
        TextView title;
        TextView code;
        TextView endDate;
    }
}
