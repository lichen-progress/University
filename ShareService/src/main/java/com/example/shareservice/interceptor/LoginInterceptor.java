package com.example.shareservice.interceptor;

import com.example.shareservice.service.UserService;
import com.example.shareservice.utils.TokenUtil;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//   let headers = new Headers();
//           headers.append('Content-Type', 'application/json');
//           headers.append('Authorization', userToken);

//拦截器实现


public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //有无Token 无 则拒绝访问
        String token = request.getHeader("Authorization");
        System.out.println("interceptor_________\n"+token);
        String mail ="";
        if (token!=null){
            mail = TokenUtil.verifyToken(token).getMail();
        }

        boolean flag = false;
        if(mail!=null){
            flag = true;
        }


        return flag;
    }

}
