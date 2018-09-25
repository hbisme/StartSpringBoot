package com.hb.start_boot.dao;

import com.hb.start_boot.entity.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

//@Mapper  改用在启动类时,扫描 mapper注解了
public interface UserMapper {

    // xml 方式
    User getUserByName(String userName);



    // 基于注解的形式,不需要mapper.xml
    @Select("select * from user where id = #{id}")
    User getUser(Long id);

    // 基于注解的形式,不需要mapper.xml
    @Select("select * from user where id = #{id} and user_name = #{name}")
    // @Param("id")对应 #{id},用来传递sql变量
    User getUserByIdAndName(@Param("id") Long id, @Param("name") String userName);

    // #{}里面的名称是 类里面的名称,不是数据库里字段的名称
    @Insert("insert into user (id, user_name, password) values (#{id}, #{userName}, #{password})")
    Integer insertUser(User user);

}



