package com.example.qqchat.Adapter;
import com.example.qqchat.Fragment.MessageActivity;
import com.example.qqchat.R;
import com.example.qqchat.bean.UserInfoWrapper;
import com.loopj.android.image.SmartImageView;


import com.example.qqchat.http.httpDownloader;
import android.media.Image;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 许超 on 2018/2/13.
 */

public class MyNewsAdapter extends BaseAdapter{

    private List<com.example.qqchat.bean.UserInfoWrapper.UserInfo> infos;
    private Context  context;

    public MyNewsAdapter(Context context, List<com.example.qqchat.bean.UserInfoWrapper.UserInfo> userInfo){
        this.context = context;
        this.infos = userInfo;
    }

    @Override
    public int getCount() {
        return infos.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       View mView;
       if(view != null){
           mView = view;

       }else{
           mView = View.inflate(context, R.layout.tab_listview_message,null);

       }
       SmartImageView smartImageView =(SmartImageView) mView.findViewById(R.id.smartImageView);
        TextView name = (TextView) mView.findViewById(R.id.name);
        TextView signature =(TextView) mView.findViewById(R.id.signature);

        com.example.qqchat.bean.UserInfoWrapper.UserInfo userInfo = infos.get(i);
        //请求的URL地址，2.显示请求失败的图片3.正在请求的图片
        smartImageView.setImageUrl(userInfo.getHead(),R.drawable.image1,R.drawable.touxiang);
      //  Log.i("test", "getView: " + userInfo.getName());
        name.setText(userInfo.getName());
        signature.setText(userInfo.getSignature());
        return mView;
    }
}
