package com.example.qqchat.FriendsList;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 许超 on 2018/3/16.
 */

public class MyTextView extends android.support.v7.widget.AppCompatTextView{
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

   public boolean isFocused(){
        return true;
   }
}
