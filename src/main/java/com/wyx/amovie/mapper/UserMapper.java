package com.wyx.amovie.mapper;

import com.wyx.amovie.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {

    //获取所有用户
    @Select("select * from user")
    List<User> getUsers();

    //根据id查询用户
    User getUserById(Integer integer);

    //根据email查询用户
    User getUserByEmail(String email);

    //保存用户
    void saveUser(User user);
}
