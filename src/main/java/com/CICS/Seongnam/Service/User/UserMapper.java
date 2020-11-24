package com.CICS.Seongnam.Service.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("SELECT PW FROM 'User' WHERE ID = ${ID} OR PW = ${PW}")
    String loginUser(String ID, String PW);
}
