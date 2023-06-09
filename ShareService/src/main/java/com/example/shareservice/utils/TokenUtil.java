package com.example.shareservice.utils;

import com.example.shareservice.entity.User;
import com.mysql.cj.util.Base64Decoder;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.*;

@Service
public class TokenUtil {

    //Token超时时间 7天
    public static long SET_TIMEOUT =7 * 24 * 60 * 60;
    //密钥
    public static String SECRET_KEY ="QTH4r2SJAkUb7NmSFRZPFdv59v927xiK";


    //生成Token
    public static String generateToken(String mail){
        Date now = new Date();
        Date expiration = new Date(now.getTime()+1000*SET_TIMEOUT);
        String token;

        token = Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(mail)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
        return token;

    }

    //验证token
    public static User verifyToken(String token){
        Claims map = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        System.out.println();
        User user = new User();
        user.setMail(map.getSubject());
        return user;
    }


//    header (base64后的)
//    payload (base64后的)
//    secret




    ////Base64URL编码
    public String baseEncode(String str){
        //转换为二进制然后编码为Base64URL
        String encodedString ;
        encodedString = Base64.getUrlEncoder().encodeToString(str.getBytes());
        System.out.println("encodedString" + encodedString);
        return encodedString;
    }
    //Base64URL解码
    public String baseDecode(String encodedString){

        byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }




    //User 转换为Json
    public String userToJson(User user){
        JSONObject jsonObj = new JSONObject(user);
        String json = jsonObj.toString();
        return json;
    }
    //User 转换为 JSONObj
    public JSONObject userToJsonObj(User user){
        JSONObject jsonObj = new JSONObject(user);
        return jsonObj;
    }
    //json 转换为 JSONObj
    public JSONObject jsonToJsonObj(String json){
        JSONObject jsonObj = new JSONObject(json);
        return jsonObj;
    }


}
