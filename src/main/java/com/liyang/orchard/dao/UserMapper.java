package com.liyang.orchard.dao;

import com.liyang.orchard.core.Mapper;
import com.liyang.orchard.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

//    @Results({
//            @Result(column="contact_id", property="contactId", jdbcType = JdbcType.INTEGER),
//            @Result(column="relationship", property="relationship", jdbcType = JdbcType.VARCHAR),
//            @Result(column="name", property="name", jdbcType = JdbcType.VARCHAR),
//            @Result(column="phone_number", property="phoneNumber", jdbcType = JdbcType.INTEGER),
//            @Result(column="stu_id", property="stuId", jdbcType = JdbcType.INTEGER)
//    })

    @Select("SELECT * from user WHERE phone=#{userPhone}")
    User findByPhone(@Param("userPhone")String phone);
}