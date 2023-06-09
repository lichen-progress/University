package com.example.shareservice.controller;

import com.example.shareservice.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    /*
    http://localhost:8080/home
    * RequestMapping
    *   value :
    *
    *

    http://localhost:8080/home?uid=114514&email=984717124@qq.com
     */


    //GET
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String hello(String uid,String email){
        return "<h1>hello world This is one last hope...</h1>"
                +"<h2>"+uid+email+"</h2>";

    }


    //Get with param
    @RequestMapping(value = "/home2",method = RequestMethod.GET)
    public String hello2(@RequestParam String uid, String email){
        return "<h1>hello world This is one last hope...</h1>"
                +"<h2>"+uid+email+"</h2>";
    }

    //POST
    @RequestMapping(value = "/post1",method = RequestMethod.POST)
    public String postTest(String uid,String nickname){
        return uid+nickname;
    }
    //http://localhost:8080/post2
    @RequestMapping(value = "/post2",method = RequestMethod.POST)
    public String postTest(@RequestBody User user){
        return user.toString();
    }
}
