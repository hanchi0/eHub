package com.jaemion.eHub.main.ui;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jaemion.eHub.R;

public class MainFragment_Main_Adapter extends PagerAdapter {

    LayoutInflater inflater;
    ImageView icon;

    public MainFragment_Main_Adapter(LayoutInflater inflater) {
        super();
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.main_viewpager_main, container, false);
        icon = view.findViewById(R.id.main_viewpager_main_icon);
        if (position == 0)
            icon.setImageResource(R.drawable.ic_cementtruck);
        else if (position == 1)
            icon.setImageResource(R.drawable.ic_excavator);
        else if(position == 2)
            icon.setImageResource(R.drawable.ic_forklift);
        else if(position == 3)
            icon.setImageResource(R.drawable.ic_dumptruck);
        else if (position == 4)
            icon.setImageResource(R.drawable.ic_ladder_truck);
        else if (position == 5)
            icon.setImageResource(R.drawable.ic_cementtruck);
        else if(position ==6)
            icon.setImageResource(R.drawable.ic_excavator);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public int getCount() {
        return 7;
    }
}
