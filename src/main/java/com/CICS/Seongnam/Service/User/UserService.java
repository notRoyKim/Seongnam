package com.CICS.Seongnam.Service.User;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    @Autowired
    UserMapper userMapper;

    public String loginUser(String ID, String PW) throws Exception {

        Map<String, Object> sqlParam = new HashMap<>();

        sqlParam.put("ID", ID);
        sqlParam.put("PW", PW);

        return userMapper.loginUser(sqlParam);
    }
}
