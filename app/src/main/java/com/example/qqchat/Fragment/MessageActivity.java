package com.example.qqchat.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.qqchat.R;

import com.example.qqchat.http.httpDownloader;
import com.example.qqchat.myQQ.PopuMenu;

/**
 * Created by 许超 on 2018/2/11.
 */

public class MessageActivity extends Fragment{

    private ListView listView;
    private Button startSettingButton;
    private View view;
    //private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_item_message,container,false);


  //     httpDownloader httpDownloader = new httpDownloader( listView,view.getContext());
     //  httpDownloader.execute();
        initView();
        return view;

    }

    @Override
    public void onStart() {
        getFragmentManager().beginTransaction().add(R.id.list_container, new ListFragment()).commit();
        super.onStart();
    }

    private void initView(){
        startSettingButton = view.findViewById(R.id.setting_button);
        startSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),PopuMenu.class));
            }
        });
    }

    public static Fragment newInstance(String from) {
        Fragment fragment = new Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return new MessageActivity();
    }
}
