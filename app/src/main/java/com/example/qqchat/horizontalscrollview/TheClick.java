package com.example.qqchat.horizontalscrollview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.qqchat.R;

/**
 * Created by 许超 on 2018/2/27.
 */

public class TheClick extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

      // ImageView imageView1 ;
      //  ImageView imageView2;
        // ImageView imageView3;
        //ImageView imageView4;
        //ImageView imageView5;


        ImageView imageView1  = (ImageView) findViewById(R.id.imageitem1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageitem2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageitem3);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageitem4);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageitem5);



        imageView1.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View view) {
                Intent itent1 = new Intent(Intent.ACTION_VIEW);
                //itent1.putExtra("Parsedata", Uri.parse("https://www.amazon.cn/"));
                itent1.setData(Uri.parse("https://www.amazon.cn/"));
                startActivity(itent1);
               //  Toast.makeText(TheClick.this, "亚马逊购物", Toast.LENGTH_SHORT).show();

            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itent2 = new Intent(Intent.ACTION_VIEW);
                itent2.setData(Uri.parse("http://www.21ic.com/calculator/kaipingfang.htm"));
                startActivity(itent2);
              //  Toast.makeText(TheClick.this, "计算器", Toast.LENGTH_SHORT).show();

            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itent3 = new Intent(Intent.ACTION_VIEW);
                itent3.setData(Uri.parse("http://rili.160.com/tools/webrili.html"));
                startActivity(itent3);
            //    Toast.makeText(TheClick.this, "日历", Toast.LENGTH_SHORT).show();

            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itent4 = new Intent(Intent.ACTION_VIEW);
                itent4.setData(Uri.parse("http://finance.sina.com.cn/realstock/company/sz300033/nc.shtml?from=BaiduAladin"));
                startActivity(itent4);
             //   Toast.makeText(TheClick.this, "股市", Toast.LENGTH_SHORT).show();
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itent5 = new Intent(Intent.ACTION_VIEW);
                itent5.setData(Uri.parse("http://rili.160.com/tools/webrili.html"));
                startActivity(itent5);
             //  Toast.makeText(TheClick.this, "你的钱包", Toast.LENGTH_SHORT).show();

            }
        });
    }



}
