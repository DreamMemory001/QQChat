package com.example.qqchat.FriendsList;

/**
 * Created by 许超 on 2018/3/16.
 */

public class People_information {
    private int draw_Id;
    private String nickname;
    private  String description;
    public  int getDraw_Id(){
        return draw_Id;
    }
    public void setDraw_Id(int draw_Id){
        this.draw_Id = draw_Id;

    }
    public String getNickname(){
        return nickname;

    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public  String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}
