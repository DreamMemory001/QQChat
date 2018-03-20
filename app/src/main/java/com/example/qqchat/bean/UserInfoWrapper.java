package com.example.qqchat.bean;

import java.util.List;

/**
 * Created by 许超 on 2018/2/13.
 */

public class UserInfoWrapper {

 public List< UserInfo> userInfo;
    public static class UserInfo{

        private String Head;
        private String name;
        private String signature;

        public String getHead(){
            return Head;
        }
        public void setHead(String head ){
            this.Head = head;
        }
        public String getName(){
            return name;

        }
        public void setName(String name){
            this.name = name;
        }
        public String getSignature(){
            return signature;

        }
        public void setSignature(String signature){
            this.signature = signature;

        }

        @Override
        public String toString() {
            return "UserInfo [Head ="+Head+",name ="+name+",signature ="+signature+" ]";

        }
    }
}
