package com.example.qqchat.Fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.qqchat.R;

/**
 * Created by 许超 on 2018/2/11.
 */

public class MyTabActivity extends FragmentActivity {
    /**
     * FragmentTabhost
     */
    private FragmentTabHost mTabHost;

    /**
     * 布局填充器
     *
     */
    private LayoutInflater mLayoutInflater;

    /**
     * Fragment数组界面
     *
     */
    private Class mFragmentArray[] = { MessageActivity.class, ContactActivity.class,
           TrendsActivity.class };
    /**
     * 存放图片数组
     *
     */
    private int mImageArray[] = {
            R.drawable.message,
            R.drawable.contact,
            R.drawable.trends
             };

   //文字
    private  String mTextArray[] = { "消息", "联系人", "动态"};



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initView();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        mLayoutInflater = LayoutInflater.from(this);

        // 找到TabHost
        mTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.tabcontent);
        // 得到fragment的个数
        int count = mFragmentArray.length;
        for (int i = 0; i < count; i++) {
            // 给每个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextArray[i])
                    .setIndicator(getTabItemView(i));
            // 将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, mFragmentArray[i], null);
            // 设置Tab按钮的背景
            mTabHost.getTabWidget().getChildAt(i)
                    .setBackgroundResource(R.drawable.selector_tab_background);
        }
    }
      private View getTabItemView(int index){
        View view = mLayoutInflater.inflate(R.layout.tab_item_view,null);
          ImageView imageView = (ImageView)view.findViewById(R.id.image_view);
          imageView.setImageResource(mImageArray[index]);
          TextView textView = (TextView)view.findViewById(R.id.text_view);
          textView.setText(mTextArray[index]);

          return view;
    }



}
