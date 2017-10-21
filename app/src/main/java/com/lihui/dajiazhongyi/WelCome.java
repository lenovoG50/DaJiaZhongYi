package com.lihui.dajiazhongyi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lihui.dajiazhongyi.fragment.WelCome1;
import com.lihui.dajiazhongyi.fragment.WelCome2;
import com.lihui.dajiazhongyi.fragment.WelCome3;

import java.util.ArrayList;

public class WelCome extends AppCompatActivity {

    private ArrayList<Fragment> welcomeFragment = new ArrayList<Fragment>();
    private ViewPager viewPager;
    private static int[] point = new int[]{
            R.drawable.point_red, R.drawable.point_nonred
    };
    private ImageView pointView;
    private ImageView[] pointImg=new ImageView[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come);
        welcomeFragment.add(new WelCome1());
        welcomeFragment.add(new WelCome2());
        welcomeFragment.add(new WelCome3());
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                selectPoint(position);
                return welcomeFragment.get(position);
            }

            @Override
            public int getCount() {
                return welcomeFragment.size();
            }
        });
        initPointView();
    }

    private void initPointView() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.pointLinearLayout);
        for (int i = 0; i < welcomeFragment.size(); i++) {
            pointView = new ImageView(this);
            if(i==0){
                pointView.setImageResource(point[0]);
            }else{
                pointView.setImageResource(point[1]);
            }
            pointImg[i]=pointView;
            linearLayout.addView(pointView);
        }
    }

    private void selectPoint(int position) {
        for (int i = 0; i < welcomeFragment.size(); i++) {
            if (i == position) {
                pointView.setImageResource(point[0]);
            } else {
                pointView.setImageResource(point[1]);
            }
        }
    }
}
