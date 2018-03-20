package com.example.qqchat.http;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;


import com.example.qqchat.Adapter.MyNewsAdapter;
import com.example.qqchat.Fragment.MessageActivity;
import com.example.qqchat.bean.UserInfoWrapper;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by 许超 on 2018/2/12.
 */

@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class httpDownloader extends AsyncTask{

    private URL url;
    private HttpURLConnection con;
    private ListView listView;
    private Context context;
    private String result;
    private ImageView imageView;


     public  httpDownloader(ListView listView,Context context){
         this.listView = listView;
         this.context = context;
    }




    public void setResult(String result){
         this.result = result;

    }
    public String getResult(){
        return result;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
         StringBuffer sb = new StringBuffer();
         String line = null;
         BufferedReader buffer = null;


        try {
            //创建一个URL
            url = new URL("http://192.168.43.109:8080/userinfos.txt");
            //建立一个http链接
            con =(HttpURLConnection) url.openConnection();
           //io流读取数据
            buffer = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while((line = buffer.readLine())!= null);
            sb.append(line);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

     @Override
    protected void onPostExecute(Object o) {
     // Log.d("main",""+(String)o);
     try {
         Gson gson = new Gson();
          //解析一个json数据转化为一个实体类
          UserInfoWrapper wrrap = new Gson().fromJson((String) o, UserInfoWrapper.class);
          //new一个adapter出来把我们的context对象和list集合传递过去
          MyNewsAdapter adapter = new MyNewsAdapter(context,wrrap.userInfo);
          listView.setAdapter(adapter);
          listView.notifyAll();
      }catch(Exception e){
          e.printStackTrace();
      }

    }
}
