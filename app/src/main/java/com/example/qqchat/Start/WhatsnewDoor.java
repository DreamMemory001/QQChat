package com.example.qqchat.Start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qqchat.Fragment.ButtomTabLayoutActivity;
import com.example.qqchat.Fragment.MyTabActivity;
import com.example.qqchat.LogLn.Login;
import com.example.qqchat.R;

/**
 * Created by 许超 on 2018/2/9.
 */

public class WhatsnewDoor extends Activity {

    private ImageView mLeft;
    private ImageView mRight;
    private TextView mText;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whats_door);

        mLeft = findViewById(R.id.image_left);
        mRight = findViewById(R.id.image_right);
        mText = findViewById(R.id.anim_text);

        //设置一个动画集合
        AnimationSet anim = new AnimationSet(true);
        /*1.确定类型 ：Absolute相对于屏幕，Relative to self 相对于自己，Relative to parent 相对于父控件
        2.确定X的起始位置
        4.确定X的结束动画的位置
        5.Y的同X一样

        *
        * */
        TranslateAnimation mytranslateanim = new TranslateAnimation(AnimationSet.RELATIVE_TO_SELF,0f,AnimationSet.RELATIVE_TO_SELF,-1f,AnimationSet.RELATIVE_TO_SELF,0f,AnimationSet.RELATIVE_TO_SELF,0f);
        //设置动画持续时间
        mytranslateanim.setDuration(2000);
        //确定动画开始时间
        anim.setStartOffset(800);
        //添加动画
        anim.addAnimation(mytranslateanim);
        //停留在最后的位置
        anim.setFillAfter(true);
        //启动动画
        mLeft.startAnimation(anim);



        AnimationSet anim2 = new AnimationSet(true);
        AnimationSet anim1 = new AnimationSet(true);
        TranslateAnimation mytranslateanim1 = new TranslateAnimation(AnimationSet.RELATIVE_TO_SELF,0f,AnimationSet.RELATIVE_TO_SELF,+1f,AnimationSet.RELATIVE_TO_SELF,0f,AnimationSet.RELATIVE_TO_SELF,0f);
        mytranslateanim1.setDuration(2000);
        anim1.addAnimation(mytranslateanim1);
        anim1.setStartOffset(800);
        anim1.setFillAfter(true);
        mRight.startAnimation(anim1);
 /*float fromX 动画起始时X坐标上得到伸缩尺寸
        float toX 动画结束时X坐标上的伸缩尺寸
        float fromY  动画起始时Y坐标上得到伸缩尺寸
        float toY 动画结束时Y坐标上的伸缩尺寸
        *int pivotXType 动画在X轴相对于物件位置类型
        * float pivotXValue 动画相对于物件的X坐标的开始位置
        * int pivotYType 动画在Y轴相对于物件的位置类型
        * float pivotYValue 动画相对于物件的Y坐标的开始位置
        *
        * */
        //缩放的特效
        ScaleAnimation myscaleanim = new ScaleAnimation(1f,3f,1f,3f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        myscaleanim.setDuration(1000);
        //渐变的特效    还有旋转的特效 Rotate
        AlphaAnimation myalphaanim = new AlphaAnimation(1,0.0001f);
        myalphaanim.setDuration(1500);
        anim2.addAnimation(myscaleanim);
        anim2.addAnimation(myalphaanim);
        anim2.setFillAfter(true);
        mText.startAnimation(anim2);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(WhatsnewDoor.this,Login.class);
                startActivity(intent);
                WhatsnewDoor.this.finish();
            }
        },2300);

    }
}

/*  使用动画的5步
1.创建AnimationSet对象
2.根据需要创建相应的Animation对象
3.根据对动画的需求。为Animation对象设置相应的数据
*4.将相应的Animation对象添加到AnimationSet对象中
* 5.使用控件对象执行AnimationSet
*
* */