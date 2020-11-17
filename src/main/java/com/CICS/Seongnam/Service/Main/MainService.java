package com.CICS.Seongnam.Service.Main;

import com.CICS.Seongnam.Domain.Main_Rand_Slide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MainService {

    @Autowired
    private MainMapper mainMapper;

    public List<Main_Rand_Slide> getMainRandSlide() {
        List<Main_Rand_Slide> tempList = new ArrayList<>();
        tempList = mainMapper.getMainRandSlide();

        for(int i = 0; i < 4 ; i++) {
            Main_Rand_Slide tempRandSlideObject = tempList.get(i);
            tempRandSlideObject.setFiles(tempRandSlideObject.getFiles().split(",")[0]);
            tempList.set(i,tempRandSlideObject);
        }

        return tempList;
    }

    //특정 데이터만 뽑아 보여주는 슬라이드, 11/18 시연용
    public List<Main_Rand_Slide> getCustomSlide() {
        List<Main_Rand_Slide> tempList = new ArrayList<>();
        tempList = mainMapper.getCustomSlide();

        for(int i = 0; i < 6 ; i++) {
            Main_Rand_Slide tempRandSlideObject = tempList.get(i);
            tempRandSlideObject.setFiles(tempRandSlideObject.getFiles().split(",")[0]);
            tempList.set(i,tempRandSlideObject);
        }

        return tempList;
    }
}
