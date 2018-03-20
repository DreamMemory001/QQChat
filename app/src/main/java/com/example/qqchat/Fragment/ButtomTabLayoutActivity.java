package com.example.qqchat.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.qqchat.R;

/**
 * Created by 许超 on 2018/2/20.
 */

public class ButtomTabLayoutActivity extends AppCompatActivity {
    private static final String TAG = "ButtomTabLayoutActivity";
  private TabLayout mTabLayout;
  private Fragment[]mFragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mFragments =DataGenerator.getFragments("TabLayout Tab");

        initView();
    }
    private  void initView(){

        mTabLayout = (TabLayout)findViewById(R.id.tab_host);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());

                //改变Tab的状态
                for(int i = 0; i <mTabLayout.getTabCount();i++){
                    if(i == tab.getPosition()){
                        mTabLayout.getTabAt(i).setIcon(getResources().getDrawable(DataGenerator.mTabResPressed[i]));
                    }else{
                        mTabLayout.getTabAt(i).setIcon(getResources().getDrawable(DataGenerator.mTabRes[i]));
                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayout.addTab(mTabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.message)).setText(DataGenerator.mTabTitle[0]));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.contact)).setText(DataGenerator.mTabTitle[1]));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.trends)).setText(DataGenerator.mTabTitle[2]));

    }
   private void  onTabItemSelected(int postion){
        Fragment fragment= null;
        switch(postion){
            case 0:
                Log.i(TAG, "onTabItemSelected: "+"0");
                fragment =mFragments[0];
                if (fragment != null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.tabcontent,fragment).commit();
                }else {
                    Log.e(TAG, "onTabItemSelected: error " );
                }

                break;
            case 1:
                Log.i(TAG, "onTabItemSelected: "+"1");
                fragment =mFragments[1];
                break;
            case 2:
                Log.i(TAG, "onTabItemSelected: "+"2");
                fragment = mFragments[2];
                break;
        }
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.tabcontent,fragment).commit();

        }
   }
}
