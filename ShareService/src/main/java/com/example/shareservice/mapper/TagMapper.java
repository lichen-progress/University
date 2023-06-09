package com.example.shareservice.mapper;

import com.example.shareservice.entity.Tag;
import com.example.shareservice.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper {

    @Select("select * from tag")
    List<Tag> selectAllTag();


    @Select("select * from resource_bind_tag where rid = #{rid} ")
    List<Tag> selectTagByRid(int rid);

    @Insert("insert into tag values(#{tag.})")
    int insertIntoTag(Tag tag);

}
