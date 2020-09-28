package com.CICS.Seongnam.Service.Main;

import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface MainMapper {
    @Select("SELECT Archive_ID FROM Archives_System_MetaData")
    String[] getallArchivesID();
}
