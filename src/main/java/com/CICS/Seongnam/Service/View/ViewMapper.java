package com.CICS.Seongnam.Service.View;

import com.CICS.Seongnam.Domain.ViewData;
import com.CICS.Seongnam.Domain.View_Data_Info;
import com.CICS.Seongnam.Domain.View_gusul_Info;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface ViewMapper {
    @Select("SELECT * FROM Archives_System_MetaData WHERE Archive_ID = '${id}';")
    ViewData getArchives(String id);

    @Select("SELECT * FROM Data_Info WHERE No = '{No}';")
    View_Data_Info getViewDataInfo(String No);

    @Select("SELECT Files FROM FILEEVENT WHERE Data_No = '${No}';")
    String getFilesByDataNo(String No);

    @Select("SELECT Words FROM Main_Words WHERE Data_No = '${No}';")
    String getMainWordsByDataNo(String No);

    @Select("SELECT * FROM gusul_Info WHERE Name_No = $'{Name_No}'")
    View_gusul_Info getViewgusulInfo(String Name_No);
}
