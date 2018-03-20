package com.example.qqchat.LogLn;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 许超 on 2018/3/13.
 */

public class Untils {
    //保存QQ号码和登录密码到 data.xml文件中
    public static boolean saveUserInfo(Context context,String number, String password){
        SharedPreferences sp = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("username",number);
        edit.putString("pwd",password);
        edit.commit();
        return true;
    }

    //从data.xml 文件中获取 储存的QQ号和密码
    public static Map<String ,String > getUserInfo(Context context){
        SharedPreferences sp = context.getSharedPreferences("data",
                Context.MODE_PRIVATE);
        String number = sp.getString("username",null);
        String password = sp.getString("pwd",null);
        Map<String,String> userMap = new HashMap<String,String>();
        userMap.put("number",number);
        userMap.put("password",password);
        return userMap;
  }
}
