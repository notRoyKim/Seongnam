package com.CICS.Seongnam.Service.Main;

import com.CICS.Seongnam.Domain.ViewData;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface MainMapper {

    @Select("SELECT Archive_ID, Title, Main_Contents, Content_Media FROM Archives_System_MetaData ORDER BY RAND() LIMIT 4;")
    List<ViewData> getMainRandSlider();
}
