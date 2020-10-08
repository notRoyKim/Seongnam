package com.CICS.Seongnam.Service.Main;

import com.CICS.Seongnam.Domain.ViewData;
import com.CICS.Seongnam.Domain.View_Data_Info;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface MainMapper {
    @Select("SELECT No, Title, Contents FROM Data_Info ORDER BY RAND() LIMIT 4;")
    List<View_Data_Info> getMainRandSliderRight();

    @Select("SELECT Files FROM FileEvent WHERE Data_No = '${No}';")
    String getMainRandSliderLeft();
}
