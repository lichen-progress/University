package com.example.shareservice.mapper;

import com.example.shareservice.entity.Resource;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ResourceMapper {
    @Select("select * from resource")
    List<Resource> selectAllResource();
    @Select("select * from resource where rid = #{rid}")
    Resource selectResourceByRid(int rid);

    @Select("select * from resource where holder = #{uid}")
    List<Resource> selectResourceByUid(int uid);

    //插入资源
    @Insert("Insert into resource(date,holder,title,html,resource) values(#{date},#{holder},#{title},#{html},#{resource})")
    int insertResource(Resource res);
    //插入User hold resource
    @Insert("Insert into user_hold_resource (rid,uid) values(#{rid},#{uid)")
    int insertUserHoldResource(int rid,int uid);

}
