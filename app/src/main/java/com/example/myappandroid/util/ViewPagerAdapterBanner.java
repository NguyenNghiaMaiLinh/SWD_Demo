package com.example.myappandroid.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myappandroid.Model.Banner;
import com.example.myappandroid.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapterBanner extends PagerAdapter {
    private Context context;
    private final List<Banner> listImage = new ArrayList<Banner>();
    private LayoutInflater layoutInflater;
    //private String[] images = {"http://www.nhaxinh.com/photo/main_banner/banner-uu-dai-nhan-nha-191030.jpg", "http://www.nhaxinh.com/photo/main_banner/banner-video-cam-hung-191023.jpg", "http://www.nhaxinh.com/photo/main_banner/thiet-ke-noi-that-191030.jpg"};

    public ViewPagerAdapterBanner(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, int postion) {
        listImage.clear();
        listImage.add(new Banner("01", "https://noithatxinh.vn/Images/Banner/mua-sofa-nhap-khau-trung-vang-2-chi-21214M.jpg"));
        listImage.add(new Banner("02", "http://www.nhaxinh.com/photo/main_banner/banner-video-cam-hung-191023.jpg"));
        listImage.add(new Banner("03", "http://www.nhaxinh.com/photo/main_banner/thiet-ke-noi-that-191030.jpg"));
        listImage.add(new Banner("04", "https://noithatxinh.vn/Images/Banner/an-tam-mua-sofa-nhap-khau-36g20x.jpg"));
        listImage.add(new Banner("05", "https://noithatxinh.vn/Images/Banner/ghe-sofa-khuyen-mai-gia-soc-tai-noi-that-xinh-0CvHcH.jpg"));
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_image, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        Picasso.get().load(listImage.get(postion).getUrlImage()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(imageView);

        ViewPager pager = (ViewPager) container;
        pager.addView(view, 0);
        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object o) {
        ViewPager pager = (ViewPager) container;
        View view = (View) o;
        pager.removeView(view);
    }
}
