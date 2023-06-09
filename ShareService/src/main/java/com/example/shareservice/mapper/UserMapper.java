package com.example.shareservice.mapper;

import com.example.shareservice.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    //获得所有用户信息
    @Select("select * from user")
    List<User> selectAllUser();

    //依据Uid查询用户
    @Select("select * from user where uid = #{uid}")
    User selectUserByUid(int uid);

    //依据mail查询用户
    @Select("select * from user where mail = #{mail}")
    User selectUserByMail(String mail);

    //插入新用户
    @Insert("insert into user (uid,name,mail,password) values(0,#{name},#{mail},#{password})")
    int insertUser(User user);

    @Update("update user set name=#{name},password=#{password},avatar=#{avatar} ,mail=#{mail}")
    int update(User user);

    @Delete("")
    int delete(int id);




}
