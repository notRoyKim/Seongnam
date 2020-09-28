package com.CICS.Seongnam.Service.Main;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface
MainMapper {

    @Select("SELECT Archive_ID FROM Archives_System_MetaData WHERE Archive_ID = '1'")
    String getallArchivesID();
}
