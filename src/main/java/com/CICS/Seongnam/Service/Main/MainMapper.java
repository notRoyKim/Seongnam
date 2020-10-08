package com.CICS.Seongnam.Service.Main;

import com.CICS.Seongnam.Domain.Main_Rand_Slide;
import com.CICS.Seongnam.Domain.ViewData;
import com.CICS.Seongnam.Domain.View_Data_Info;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface MainMapper {
    @Select("SELECT No, Title, Contents, Files FROM Data_Info,FileEvent ORDER BY Rand() LIMIT 4;")
    List<Main_Rand_Slide> getMainRandSlide();
}
