package com.CICS.Seongnam.Service.Main;

import com.CICS.Seongnam.Domain.Main_Rand_Slide;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface MainMapper {
    @Select("SELECT * FROM MainRandSlideView ORDER BY Rand() LIMIT 4;")
    List<Main_Rand_Slide> getMainRandSlide();
}
