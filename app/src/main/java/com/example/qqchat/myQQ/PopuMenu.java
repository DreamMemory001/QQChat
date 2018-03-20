package com.example.qqchat.myQQ;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.qqchat.R;
import com.example.qqchat.http.httpDownloader;


/**
 * Created by 许超 on 2018/3/8.
 */

public class PopuMenu extends AppCompatActivity implements View.OnClickListener,PopupMenu.OnMenuItemClickListener
{
    private Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_item_message);
        button1 =findViewById(R.id.setting_button);
        button1.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        //创建弹出菜单对象
        PopupMenu popup = new PopupMenu(this,view );
   //获取菜单填充器
        MenuInflater inflater = popup.getMenuInflater();
        //填充菜单
        inflater.inflate(R.menu.popumenu,popup.getMenu());
        //绑定菜单栏的点击事件
        popup.setOnMenuItemClickListener(this);
        //显示
        popup.show();



    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {


        switch (menuItem.getItemId()){
            case  R.id.item1:
                Toast.makeText(this,"添加...",Toast.LENGTH_SHORT).show();
                   break;
            case R.id.item2:
                Toast.makeText(this, "删除...", Toast.LENGTH_SHORT).show();
                   break;
            case R.id.item3:
                Toast.makeText(this,"复制...",Toast.LENGTH_SHORT).show();
                   break;
            default :
                break;


        }
        return false;
    }
}
