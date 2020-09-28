package com.CICS.Seongnam.Service.Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private MainMapper mainMapper;

    public String[] getallArchivesID() throws Exception {
        return mainMapper.getallArchivesID();
    }
}
