package com.example.shareservice.service;

import com.example.shareservice.entity.Resource;
import com.example.shareservice.entity.User;
import com.example.shareservice.mapper.ResourceMapper;
import com.example.shareservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {
    @Autowired
    ResourceMapper resourceMapper;
    @Autowired
    UserMapper userMapper;


    /*
     * 创建资源
     * */
    public boolean putResource(User user,Resource resource){
        //
        System.out.println("service-----putResource-------------------------------------");
        resource.setHolder(user.getUid());
        int state = resourceMapper.insertResource(resource);
        System.out.println(state);
        if (state == 1){

            System.out.println(user.getUid()+"\n"+resource.getRid());
//            resourceMapper.insertUserHoldResource(user.getUid(),resource.getRid());
            return true;
        }else {
            return false;
        }

    }

    /*
    *
    * */
    public Resource getResourceByRid(int rid){
        Resource resource = resourceMapper.selectResourceByRid(rid);
        System.out.println("service-----getResourceByRid--------------------\n" + resource);
        return resource;
    }

    /*
     *
     * */
    public List<Resource> getResourceByUid(int uid){
        List<Resource> resource = resourceMapper.selectResourceByUid(uid);
        System.out.println("service-----getResourceByUid--------------------\n" + resource);
        return resource;
    }

    /*
     *
     * */
    public List<Resource> getResource(){
        List<Resource> resource = resourceMapper.selectAllResource();
        System.out.println("service--------------------\n" + resource);
        return resource;
    }

}
