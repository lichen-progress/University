package com.example.shareservice.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.shareservice.entity.User;
import com.example.shareservice.mapper.UserMapper;
import com.example.shareservice.service.UserService;
import com.example.shareservice.utils.Result;
import com.example.shareservice.utils.TokenUtil;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    /*
    http://localhost:8080/home
    * RequestMapping
    *   value :
    *
    *

    http://localhost:8080/home?uid=114514&email=984717124@qq.com
     */
    /*
    *
    *
    * */
    @GetMapping("/userInfo")
    public Result getUserInfoByToken(){
        return Result.ok();
    }

    @PostMapping(value = "/alert/{uid}")
    public Result reSetUser(@PathVariable int uid){

        return Result.ok().resultMessage("测试拦截器");
    }


    //Getter
    //获得所有已注册用户信息
    @GetMapping(value = "/getUsers")
    public List<User> getAllUsers(){
        List<User> users = userMapper.selectAllUser();
        System.out.printf(userService.toString());
        System.out.println(users);
        return users;
    }

    /* 注册
     * request
     * @param        uid
     *
     * respond
     * @param        Result.data.message
     * */
    @GetMapping(value = "/{uid}")
    public Result getUserByUid(@PathVariable int uid){
        return Result.ok();
    }



    /* 注册
     * request
     * @param        user.mail
     * @param        user.password
     * @param        user.name
     *
     * respond
     * @param        Result.data.message
     * */
    @PostMapping("/register")
    public Result registerUser(@RequestBody User user){
        System.out.println("Register port is using!\n");
        System.out.println(user.toString());
        userService.registerUserByMail(user);

        return Result.ok().resultMessage("注册成功");
    }
    /*
    @PostMapping(value = "/register")
    public String registerUser(@RequestBody Integer uid,){
        User user = new User();
        user.setUid(uid);
        user.setName(name);
        user.setPassword(password);
        user.setMail(mail);
        System.out.println(user.toString());
        userService.setUserByUid(user);
        return "成功";
    }*/


    /* 普通登录
    * request
    * @param        user.mail
    * @param        user.password
    *
    * respond
    * @param        Result.data.token
    * */
    @PostMapping(value = "/login")
    public Result userLogin(@RequestBody User user) {

        String token = userService.verifyUser(user.getMail(), user.getPassword());
        System.out.println("__token__________________________");
        System.out.println(token);

        if (token.isEmpty()) {
            return Result.error();
        } else {
            return Result.ok().putData("token", token);
        }
    }

    /* token登录
     * request
     *
     * respond
     * @param        Result.data.token
     * */
    @GetMapping("/login")
    public Result tokenLogin(@RequestHeader("Authorization") String token){

        User usermail = TokenUtil.verifyToken(token);
        User user = userService.getUserByMail(usermail.getMail());
        System.out.println(user.getName());
        if (user != null){
            return Result.ok().putData("userProfile",user);
        }else {
            return Result.error();
        }


    }


    //关联查询


}
