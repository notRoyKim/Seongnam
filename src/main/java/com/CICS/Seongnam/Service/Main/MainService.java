package com.CICS.Seongnam.Service.Main;

import com.CICS.Seongnam.Domain.ViewData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MainService {

    @Autowired
    private MainMapper mainMapper;

    public List<ViewData> getMainRandSlider() throws  Exception {
        return mainMapper.getMainRandSlider();
    }
}
