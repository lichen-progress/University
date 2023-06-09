package com.example.shareservice.utils;

import com.example.shareservice.entity.User;

import java.util.HashMap;

public class Result {
    Result(){
        this.data = new HashMap<String,Object>();
    }
    Result(int code){
        this.code =code;
        this.data = new HashMap<String,Object>();
    }
    private int code;
    private String message;
    //data
    public HashMap<String,Object> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public int getCode() {
        return code;

    }

    public void setCode(int code) {
        this.code = code;
    }

    public HashMap<String, Object> getData() {
        return data;
    }
    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }


    public Result resultMessage(String text){
        this.message = text;
        return this;
    }


    public Result putData(String key, Object value) {

        System.out.println("++++++++++++++++++++++++++++++\n"+key+value);
        this.data.put(key,value);
        return this;
    }

    public static Result ok(){
        Result r = new Result(200);
        return r;
    }

    public static Result error(){
        return new Result(500);
    }


}
