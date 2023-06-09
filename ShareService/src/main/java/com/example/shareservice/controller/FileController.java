package com.example.shareservice.controller;


import com.example.shareservice.entity.Resource;
import com.example.shareservice.entity.User;
import com.example.shareservice.service.ResourceService;
import com.example.shareservice.service.UserService;
import com.example.shareservice.utils.Result;
import com.example.shareservice.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;



@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {
    @Autowired
    UserService userService;
    @Autowired
    ResourceService resourceService;


    //上传资源
    @PostMapping("/upload/resource")
    public Result uploadResource(@RequestHeader("Authorization") String token, @RequestBody Resource resource){
        //得到上传用户
        User usermail = TokenUtil.verifyToken(token);
        User user = userService.getUserByMail(usermail.getMail());
        System.out.println(user.getName()+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        boolean rState = false;
        if (user != null){

            rState = resourceService.putResource(user,resource);
        }
        if (rState){
            return Result.ok();
        }
        else {
            return Result.error();
        }

    }



    /*上传文件
    *
    *
    *
    * */
    @PostMapping("/upload/file")
    public String upload(String name, MultipartFile file, HttpServletRequest request) throws IOException {

        System.out.println(name);
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        System.out.println(file.getName()+file.getSize());


        String path = request.getServletContext().getRealPath("/uplaod/");
        System.out.println(path);


        save(file,"C:\\ShareFile\\avatars\\");
        return "Done!";
    }
    /*下载
     *
     *
     *
     * */
    @GetMapping("/download/file")
    public Result download(){
        return  Result.ok();
    }






    private String save(MultipartFile data,String path)throws IOException {
        String dataName = data.getOriginalFilename();
        final String dataLocated ="C:\\ShareFile\\avatars\\";


        File f = new File("C:\\ShareFile\\avatars");
        if (!f.exists()){
            f.mkdir();
        }

        if (!data.isEmpty()){
            File file = new File(dataLocated+ dataName);
            data.transferTo(file);
        }


        return "saved in " + dataName;
    }

}
