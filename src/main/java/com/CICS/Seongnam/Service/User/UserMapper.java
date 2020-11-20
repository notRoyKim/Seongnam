package com.CICS.Seongnam.Service.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("SELECT ID FROM User WHERE ID = ${ID} AND PW = password(${PW})")
    String loginUser(Map<String, Object> sqlParam);
}
