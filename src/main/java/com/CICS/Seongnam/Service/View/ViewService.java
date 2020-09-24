package com.CICS.Seongnam.Service.View;

import com.CICS.Seongnam.Domain.ViewData;
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
}
