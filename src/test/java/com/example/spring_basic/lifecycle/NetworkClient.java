package com.example.spring_basic.lifecycle;


public class NetworkClient  {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " +url);
    }
    public void setUrl(String url){
        this.url = url;
    }
    public void connect(){
        System.out.println("connect(); = " + url);
    }
    public void call(String message){
        System.out.println("call :" + url + "message = " + message  );

    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close" + url);
    }

}
