package com.wyx.amovie.mapper;

import com.wyx.amovie.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author wyx
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 获取所有用户
     *
     * @return
     */
    @Select("select * from user")
    List<User> getUsers();

    /**
     * 根据id查询用户
     *
     * @param integer
     * @return
     */
    User getUserById(Integer integer);

    /**
     * 根据email查询用户
     *
     * @param email
     * @return
     */
    @Select("select * from user where email=#{email}")
    User getUserByEmail(String email);

    /**
     * 保存用户
     *
     * @param user
     */
    @Insert("insert into user(nickname,email,password,salt,phone,gender,role)" +
            "values(#{nickname},#{email},#{password},#{salt},#{phone},#{gender},#{role})")
    void saveUser(User user);
}
