package com.example.qqchat.Start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.qqchat.R;

import java.util.ArrayList;

/**
 * Created by 许超 on 2018/2/9.
 */

public class PagerActivity extends Activity {
 private ViewPager mViewPager ;
 private Button startButton;


    @Override
            protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_activity);

        mViewPager = findViewById(R.id.viewpager);
        //将要分页显示的View装入数组中
        LayoutInflater mLi = LayoutInflater.from(this);
        View view1 = mLi.inflate(R.layout.viewpager_activity_item1,null);
        View view2 = mLi.inflate(R.layout.viewpager_activity_item2,null);
        View view3 = mLi.inflate(R.layout.viewpager_activity_item3,null);

        //每个页面的Title数据
        final ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);


        //填充ViewPager的数据适配器
        PagerAdapter  mPagerAdapter = new PagerAdapter(){
            //确定页面个数
            @Override
            public int getCount() {
                return views.size();
            }
            //比较
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }
            //确定要删除的页面

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ((ViewPager)container).removeView(views.get(position));
            }
             //确定需要加载的页面
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ((ViewPager)container).addView(views.get(position));
                return views .get(position);
            }
        };
        //添加进入到适配器
        mViewPager.setAdapter(mPagerAdapter);
    }
//button的点击事件
    public void startbutton(View view){

        Intent intent = new Intent();
        intent.setClass(PagerActivity.this,WhatsnewDoor.class);
        startActivity(intent);
        this.finish();
    }
}
