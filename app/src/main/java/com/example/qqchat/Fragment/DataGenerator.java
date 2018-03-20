package com.example.qqchat.Fragment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qqchat.R;



/**
 * Created by 许超 on 2018/2/20.
 */

public class DataGenerator {

    public static final int []mTabRes =new int[]{R.drawable.message,R.drawable.contact,R.drawable.trends};
    public static final int []mTabResPressed = new int[]{R.drawable.message_ic ,R.drawable.contact_ic ,R.drawable.trends_ic};
    public static final String []mTabTitle = new String[]{"消息","联系人","动态"};

    public static Fragment[] getFragments(String from){
        Fragment fragments[] = new Fragment[3];
        fragments[0] = MessageActivity.newInstance(from);
        fragments[1] = ContactActivity.newInstance(from);
        fragments[2] = TrendsActivity.newInstance(from);
        return fragments;


    }

    public static View getTabView(Context context,int postion){
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item_message,null);
        ImageView tabIcon =(ImageView)view.findViewById(R.id.image_view);
        tabIcon.setImageResource(DataGenerator.mTabRes[postion]);
        TextView tabText = (TextView) view.findViewById(R.id.text_view);
        tabText.setText(mTabTitle[postion]);
        return view ;


    }
}
