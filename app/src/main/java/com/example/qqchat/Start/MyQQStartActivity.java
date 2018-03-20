package com.example.qqchat.Start;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.qqchat.R;

public class MyQQStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_qqstart);
        // new一个handler 进行跳转事件的设置
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(MyQQStartActivity.this,PagerActivity.class);
                startActivity(intent);
                MyQQStartActivity.this.finish();
            }
        },2300);
    }
}
