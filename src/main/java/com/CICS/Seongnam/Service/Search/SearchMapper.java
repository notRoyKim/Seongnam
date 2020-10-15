package com.CICS.Seongnam.Service.Search;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SearchMapper {
    @Select("SELECT Data_Info.No FROM `Data_Info` JOIN Gusul_Info WHERE Data_Info.Name_No = Gusul_Info.Name_No AND (Gusul_Info.Name LIKE '%${SearchWord}%' OR Data_Info.Title LIKE '%${SearchWord}%' OR Data_Info.Data_Background LIKE '%${SearchWord}%' OR Data_Info.Contents LIKE '%${SearchWord}%') ORDER BY Data_Info.No DESC")
    String getSearchResultNo(String SearchWord);
}
