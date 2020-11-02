package com.CICS.Seongnam.Service.Search;

import com.CICS.Seongnam.Domain.Search_Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface SearchMapper {
    @Select("SELECT Data_Info.No FROM `Data_Info` JOIN Gusul_Info WHERE Data_Info.Name_No = Gusul_Info.Name_No AND (Gusul_Info.Name LIKE '%${SearchWord}%' OR Data_Info.Title LIKE '%${SearchWord}%' OR Data_Info.Data_Background LIKE '%${SearchWord}%' OR Data_Info.Contents LIKE '%${SearchWord}%') ORDER BY Data_Info.No DESC")
    List<String> getSearchResultNo(String SearchWord);

    @Select("SELECT No, Title, Name, Files, COUNT(No) as T_count FROM SearchResultView WHERE No = '${No}';")
    List<Search_Result> getSearchResultByNo(List<String> No);
}
