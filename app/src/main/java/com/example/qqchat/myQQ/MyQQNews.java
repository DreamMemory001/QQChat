package com.example.qqchat.myQQ;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.qqchat.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 许超 on 2018/2/15.
 */

public class MyQQNews extends Activity{
    private  static ListView listView;
    private Button button;
    List<Map<String,Object>> moreList;
    private PopupWindow pwMyPopWindow;
    private SimpleAdapter simpleAdapter;
    private ListView  lvPopupLsit;//popupwindwo下的Listview
    private int NUM_OF_LIST_ROWS = 3;//指定popupwindow中 item个数



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_item_message);
        listView = findViewById(R.id.below_list);
        button = findViewById(R.id.setting_button);
        iniDtata();
        iniPopupWindow();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pwMyPopWindow.isShowing()){
                    pwMyPopWindow.dismiss();//关闭
                }else{
                    pwMyPopWindow.showAsDropDown(button);//显示
                }
            }
        });

      //  httpDownloader httpDownloader = new httpDownloader(this ,listView );
        //httpDownloader.execute();
        listView .setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent .setClass(MyQQNews.this,MyQQMessage.class);
                startActivity(intent);

            }
        });
    }

    private  void iniDtata(){
        moreList =new ArrayList<>();
        Map<String,Object > map;
        map = new HashMap<>();
        map.put("share_key","复制");
        moreList.add(map);
        map = new HashMap<>();
        map.put("share_key","删除");
        moreList.add(map);
        map = new HashMap<>();
        map.put("share_key","修改");
        moreList.add(map);
        Log.e("data", "map, end");
    }
    //进项初始化操作
    private  void iniPopupWindow(){
        Log.e("popopen", "begin");
        LayoutInflater inflater = (LayoutInflater)this
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.task_detail_popupwindow,null);
        lvPopupLsit = (ListView)findViewById(R.id.lv_popup_list);
        pwMyPopWindow = new PopupWindow(layout);
        //加上这个popupwindow中的ListView可以接收点击事件；
        pwMyPopWindow.setFocusable(true);
        //设置ListAdapter集合
        simpleAdapter = new SimpleAdapter(MyQQNews.this, moreList, R.layout.list_item_popupwindow, new String[]{"share_key"}, new int[]{R.id.lv_list_item});

        lvPopupLsit.setAdapter(simpleAdapter);
        //设置点击事件
        lvPopupLsit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MyQQNews.this,moreList.get(i).get("share_key").toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        //控制Popupwindow的宽度和高度
        lvPopupLsit.measure(View.MeasureSpec.UNSPECIFIED,
                View.MeasureSpec.UNSPECIFIED);
        pwMyPopWindow.setWidth(lvPopupLsit.getMeasuredWidth());
        pwMyPopWindow.setHeight(lvPopupLsit.getHeight()* NUM_OF_LIST_ROWS);
        pwMyPopWindow.setBackgroundDrawable(this.getResources().getDrawable(
                R.drawable.bg_popupwindow
        ));//因为popupwindow是阻塞的 最后要返回一个背景图 才能是返回之后得到相应的界面
        pwMyPopWindow.setOutsideTouchable(true);//点击除了popupwindow之外的的东西 使他返回

    }
}
