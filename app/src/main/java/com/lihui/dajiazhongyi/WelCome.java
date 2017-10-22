package com.lihui.dajiazhongyi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WelCome extends AppCompatActivity {

    private ViewPager viewPager;
    private static int[] point = new int[]{
            R.drawable.point_red, R.drawable.point_nonred
    };
    ArrayList<View> list = new ArrayList<View>();
    private ImageView pointView;
    private View view1;
    private View view2;
    private View view3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come);

        //导入布局
        initView();

        list.add(view1);
        list.add(view2);
        list.add(view3);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                container.addView(list.get(position));
                selectPointColor(position);
                return list.get(position);
            }
        });
        initPointView();
    }

    private void initView() {
        view1 = LayoutInflater.from(this).inflate(R.layout.welcome1, null);
        view2 = LayoutInflater.from(this).inflate(R.layout.welcome2, null);
        view3 = LayoutInflater.from(this).inflate(R.layout.welcome3, null);
        view3.findViewById(R.id.titleView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelCome.this, Home.class));
                SharedPreferences preferences = getSharedPreferences("open", MODE_PRIVATE);
                SharedPreferences.Editor edit = preferences.edit();
                edit.putBoolean("first", false);
                edit.commit();
            }
        });
    }

    //添加小圆点
    private void initPointView() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.pointLinearLayout);

        for (int i = 0; i < list.size(); i++) {
            pointView = new ImageView(this);
            if (i == 0) {
                pointView.setImageResource(point[0]);
            } else {
                pointView.setImageResource(point[1]);
            }
            linearLayout.addView(pointView);
        }
    }

    //选择颜色
    private void selectPointColor(int position) {
        for (int i = 0; i < list.size(); i++) {
            if (i == position) {
                pointView.setImageResource(point[0]);
            } else {
                pointView.setImageResource(point[1]);
            }
        }
    }
}
