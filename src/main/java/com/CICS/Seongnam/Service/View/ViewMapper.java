package com.CICS.Seongnam.Service.View;

import com.CICS.Seongnam.Domain.View_Data_Info;
import com.CICS.Seongnam.Domain.View_Gusul_Info;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ViewMapper {
    @Select("SELECT * FROM Data_Info WHERE No = '${No}';")
    View_Data_Info getViewDataInfo(String No);

    @Select("SELECT Files FROM FileEvent WHERE Data_No = '${No}';")
    String getFilesByDataNo(String No);

    @Select("SELECT Words FROM Main_Words WHERE Data_No = '${No}';")
    String getMainWordsByDataNo(String No);

    @Select("SELECT * FROM Gusul_Info WHERE Name_No = '${Name_No}'")
    View_Gusul_Info getViewGusulInfo(String Name_No);
}
