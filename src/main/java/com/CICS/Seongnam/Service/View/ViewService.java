package com.CICS.Seongnam.Service.View;

import com.CICS.Seongnam.Domain.ViewData;
import com.CICS.Seongnam.Domain.View_Data_Info;
import com.CICS.Seongnam.Domain.View_Gusul_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ViewService {

    @Autowired
    private ViewMapper viewMapper;

    public View_Data_Info getViewDataInfo(String No) {
        return viewMapper.getViewDataInfo(No);
    }

    public String getFilesByDataNo(String No) {
        return viewMapper.getFilesByDataNo(No);
    }

    public String getMainWordsByDataNo(String No) {
        return viewMapper.getMainWordsByDataNo(No);
    }

    public View_Gusul_Info getViewGusulInfo(String Name_No) {
        return viewMapper.getViewGusulInfo(Name_No);
    }
}
