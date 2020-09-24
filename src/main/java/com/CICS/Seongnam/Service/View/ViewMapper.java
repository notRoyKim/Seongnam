package com.CICS.Seongnam.Service.View;

import com.CICS.Seongnam.Domain.ViewData;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface ViewMapper {
    @Select("SELECT * FROM Archives_System_MetaData WHERE Archive_ID = '${id}';")
    ViewData getArchives(String id);
}
