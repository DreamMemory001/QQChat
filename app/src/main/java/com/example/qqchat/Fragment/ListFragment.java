package com.example.qqchat.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qqchat.Adapter.MyAdapter;
import com.example.qqchat.FriendsList.People_information;
import com.example.qqchat.R;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    private View view;
    private int id[] = {R.drawable.image1_item,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9};
    private String nickname[] = {"Mike","许亚茹","徐一鸣","张敏铭","刘子龙","郑小慧","张峰","罗玥","刘熙"};
    private String description[] = {"我要成为一位伟大的程序员","今天过生日，祝福我吧！","机车，我的最爱","明天即将成为一名医生了！","希望将来可以去到外太空哦","我要成为最美的白天鹅！","巴黎，我来了！","最美的期待在明天，希望是惊喜！","刺眼的阳光,我的梦！"};

    private ListView lv_view;
    private MyAdapter myAdapter;
    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        initView();
        return view;
    }

    private void initView(){
        lv_view = view.findViewById(R.id.below_list);
        myAdapter = new MyAdapter();

        myAdapter.setContext(view.getContext());
        myAdapter.setmData(getList());
        lv_view.setAdapter(myAdapter);
        lv_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                People_information people = (People_information) myAdapter.getItem(i);
                Toast.makeText(view.getContext(),"昵称:"+people.getNickname()+"\n个性标签:"+people.getDescription(),Toast.LENGTH_LONG).show();
            }
        });
    }
    private List<People_information> getList(){
        List<People_information> list = new ArrayList<People_information>();
        for (int i = 0 ; i <id.length;i++){
            People_information people = new People_information();
            people.setDraw_Id(id[i]);
            people.setNickname(nickname[i]);
            people.setDescription(description[i]);
            list .add(people);
        }
        return list;
    }
}
