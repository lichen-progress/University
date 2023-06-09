package com.example.shareservice.service;

import com.example.shareservice.entity.User;
import com.example.shareservice.mapper.UserMapper;
import com.example.shareservice.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {



    @Autowired
    UserMapper userMapper;





    public Boolean isTokenTrue(String token){
        User loginedUser = TokenUtil.verifyToken(token);
        String mail = loginedUser.getMail();
        System.out.println("isTokenTrue++++++++++\n"+loginedUser.getMail());
        User user =  getUserByMail(mail);
        System.out.println("isTokenTrue++++++++++\n"+user.getMail());
        if (user!=null){
            return true;
        }else {
            return false;
        }

    }



    private String test;
    public void UserService(){
        System.out.printf("test is Created");
    }


    public String createToken(User user){
        String token = TokenUtil.generateToken(user.getMail());
        return token;
    }



    //从用户名与密码验证user
    public String verifyUser(String mail,String password){
        User user = userMapper.selectUserByMail(mail);
        System.out.println("verify_______________________________________________________________________________-");
        System.out.println(user.getPassword() + password);
        boolean flag = user.getPassword().equals(password)?true:false;
        System.out.println(flag+"flas");
        if (flag){
            String token = createToken(user);
            TokenUtil.verifyToken(token);
            return token;
        }else {
            return null;
        }
    }

    /*
    * @param uid
    * */
    public User getUserByUid(int uid){
        User test = userMapper.selectUserByUid(uid);
        test.setPassword("0");
        System.out.println(test);
        return test;
    }

    public int registerUserByMail(User user){
        if(userMapper.selectUserByMail(user.getMail())==null){
            userMapper.insertUser(user);
            return 1;
        }else {
            return 0;
        }

    }

    public User getUserByMail(String mail){
        return userMapper.selectUserByMail(mail);
    }

}
