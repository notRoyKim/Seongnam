package com.CICS.Seongnam.Service.View;

import com.CICS.Seongnam.Domain.ViewData;
import com.CICS.Seongnam.Domain.View_Data_Info;
import com.CICS.Seongnam.Domain.View_gusul_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ViewService {

    @Autowired
    private ViewMapper viewMapper;

    public ViewData getArchives(String id) throws Exception {
        return viewMapper.getArchives(id);
    }

    public View_Data_Info getViewDataInfo(String No) {
        return viewMapper.getViewDataInfo(No);
    }

    public String getFilesByDataNo(String No) {
        return viewMapper.getFilesByDataNo(No);
    }

    public String getMainWordsByDataNo(String No) {
        return viewMapper.getMainWordsByDataNo(No);
    }

    public View_gusul_Info getViewgusulInfo(String Name_No) {
        return viewMapper.getViewgusulInfo(Name_No);
    }
}
