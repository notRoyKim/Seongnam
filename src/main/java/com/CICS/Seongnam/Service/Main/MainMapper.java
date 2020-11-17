package com.CICS.Seongnam.Service.Main;

import com.CICS.Seongnam.Domain.Main_Rand_Slide;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface MainMapper {
    @Select("SELECT * FROM MainRandSlideView ORDER BY Rand() LIMIT 4;")
    List<Main_Rand_Slide> getMainRandSlide();

    @Select("SELECT * FROM MainRandSlideView WHERE No = '25' OR No = '26' OR No = '29' OR No = '30' OR No = '31' OR No = '32'")
    List<Main_Rand_Slide> getCustomSlide();
}
