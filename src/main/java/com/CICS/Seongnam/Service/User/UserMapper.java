package com.CICS.Seongnam.Service.User;

import org.apache.ibatis.annotations.Select;
import java.util.Map;

public interface UserMapper {

    @Select("SELECT ID, PW, NGO_ID, CGI_ID, LAST_NAME FROM USER WHERE ID = #{ID} AND PW =#{PW}")
    Map<String, Object> loginUser(Map<String, Object> sqlParam);
}
