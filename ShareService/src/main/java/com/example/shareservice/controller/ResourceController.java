package com.example.shareservice.controller;


import com.example.shareservice.entity.Resource;
import com.example.shareservice.entity.User;
import com.example.shareservice.mapper.ResourceMapper;
import com.example.shareservice.service.ResourceService;
import com.example.shareservice.service.UserService;
import com.example.shareservice.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resource")
@CrossOrigin
public class ResourceController {
    @Autowired
    ResourceService resourceService;
    @Autowired
    UserService userService;
    @Autowired
    ResourceMapper resourceMapper;


    @GetMapping("/test")
    public Result test() {
        Resource resource = resourceMapper.selectResourceByRid(4);
        System.out.println(resource);
        return Result.ok().putData("r",resource);
    }

    @GetMapping("/{rid}")
    public Result getResourceByRid(@PathVariable int rid){
        Resource resource = resourceService.getResourceByRid(rid);
        System.out.println("controller+++++++++++++++++++++++++++++++++\n"+resource.toString());

        return Result.ok().putData("resource",resource);
    }
    @GetMapping("/resourceAndUser/{uid}")
    public Result getResourceAndHolderByUid(@PathVariable int uid){
        System.out.println("controller--------getResourceAndHolderByUid-----------\n");
        List<Resource> resource = resourceService.getResourceByUid(uid);
        User user = userService.getUserByUid(uid);


        Result result = Result.ok().putData("resources",resource);
        result.putData("user",user);
        System.out.println("Controller++++++++++++++++++++\n"+result);
        return result;
    }

    @GetMapping("/resourceAndUser")
    public Result getResourceAndHolder(){

        System.out.println("controller--------getResourceAndHolder-----------\n");
        List<Resource> resources = resourceService.getResource();

        Result result = Result.ok().putData("resources",resources);

        List<User> users = new ArrayList<User>();

        for(Resource resource:resources){


            users.add(userService.getUserByUid(resource.getHolder()));
        }

        result.putData("users",users);
        System.out.println("Controller++++++++++++++++++++\n"+result);
        return result;
    }


}
