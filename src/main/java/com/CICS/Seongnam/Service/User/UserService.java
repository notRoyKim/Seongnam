package com.CICS.Seongnam.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public String loginUser(String ID, String PW) throws Exception {
        PW = "*D8AA5746E4659AC7A460F32C20AEB6F7BB3FBC01";
        System.out.println(PW);
        return userMapper.loginUser(ID, PW);
    }
}
