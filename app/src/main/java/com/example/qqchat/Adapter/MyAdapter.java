package com.example.qqchat.Adapter;

import android.content.Context;
import android.provider.Contacts;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qqchat.FriendsList.People_information;
import com.example.qqchat.R;

import java.util.List;

/**
 * Created by 许超 on 2018/3/16.
 */

public class MyAdapter extends BaseAdapter{

    private List<People_information>mData;
    private Context context;
    public void setmData(List mData){
        this.mData = mData;
    }
    public void setContext(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      View view1 = View.inflate(context, R.layout.adapter_view,null);
     //获取item对应的数据对象
      People_information people = mData.get(i);
      // 初始化view
        ImageView iv_picture = view1.findViewById(R.id.iv_picture);
        TextView tv_nickname = view1.findViewById(R.id.tv_nickname);
        TextView tv_description  = view1.findViewById(R.id.tv_description);

        //绑定数据到view
        iv_picture.setImageResource(people.getDraw_Id());
        tv_nickname.setText(people.getNickname());
        tv_description.setText(people.getDescription());





        return view1;
    }
}
