package com.example.myappandroid.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myappandroid.Model.Discount;
import com.example.myappandroid.Model.Order;
import com.example.myappandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class OrderListAdapter extends BaseAdapter {
    private List<Order> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public OrderListAdapter(List<Order
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
            convertView = layoutInflater.inflate(R.layout.item_order, null);
            holder = new ViewHolder();
            holder.imageOrder = (ImageView) convertView.findViewById(R.id.imageOrder);
            holder.name = (TextView) convertView.findViewById(R.id.txtOrderName);
            holder.priceNew = (TextView) convertView.findViewById(R.id.txtOrderPriceNew);
            holder.priceOld = (TextView) convertView.findViewById(R.id.txtOrderPriceOld);
            holder.providedBy = (TextView) convertView.findViewById(R.id.txtOrderProvidedBy);
            holder.quantity = (TextView) convertView.findViewById(R.id.orderQuantity);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Order order = this.list.get(i);
        holder.name.setText(order.getName());
        holder.quantity.setText(String.valueOf(((Order) order).getQuantity()));
        holder.priceOld.setText(parseString(order.getPrice()));
        holder.priceNew.setText(computePrice(order.getPrice(), order.getSale()));
        holder.providedBy.setText(order.getProvidedBy());
        Picasso.get().load(order.getUrlImage()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(holder.imageOrder);
        return convertView;
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


    static class ViewHolder {
        ImageView imageOrder;
        TextView name;
        TextView priceNew;
        TextView priceOld;
        TextView providedBy;
        TextView quantity;
    }
}
