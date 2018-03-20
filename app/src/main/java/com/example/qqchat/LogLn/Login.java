package com.example.qqchat.LogLn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qqchat.Fragment.ButtomTabLayoutActivity;
import com.example.qqchat.R;

import java.util.Map;

/**
 * Created by 许超 on 2018/3/13.
 */

public class Login extends AppCompatActivity implements View.OnClickListener{
    private EditText etNumber;
    private EditText etPassword;
    private Button  logButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        initView();

        //取出号码
        Map<String,String>userInfo = Untils.getUserInfo(this);
        if(userInfo != null){
            //显示在界面上
            etNumber.setText(userInfo.get("number"));
            etPassword.setText(userInfo.get("password"));
            logButton = findViewById(R.id.btn_login);

           logButton.setOnClickListener(new View .OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Login.this,ButtomTabLayoutActivity.class) ;
                    startActivity(intent);
                }
            });
        }
    }

    private void initView() {
        etNumber = findViewById(R.id.et_number);
        etPassword = findViewById(R.id.et_password);
        logButton = findViewById(R.id.btn_login);
    }

    @Override
    public void onClick(View view) {
          String number = etNumber.getText().toString().trim();
          String password = etPassword.getText().toString();
          //检验密码是否正确
        if(TextUtils.isEmpty(number)){
            Toast.makeText(this,"请输入QQ号...",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
            return ;
        }
        //登录成功
        Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();

        Log.i("Login","记住密码:"+number+","+password);

        boolean issaveSuccess = Untils.saveUserInfo(this,number,password);
        if (issaveSuccess){
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show();
        }
    }
}
