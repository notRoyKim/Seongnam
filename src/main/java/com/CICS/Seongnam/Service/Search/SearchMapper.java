package com.CICS.Seongnam.Service.Search;

import com.CICS.Seongnam.Domain.Search_Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface SearchMapper {
    @Select("SELECT Data_Info.No FROM `Data_Info` JOIN Gusul_Info WHERE Data_Info.Name_No = Gusul_Info.Name_No AND (Gusul_Info.Name LIKE '%${SearchWord}%' OR Data_Info.Title LIKE '%${SearchWord}%' OR Data_Info.Data_Background LIKE '%${SearchWord}%' OR Data_Info.Contents LIKE '%${SearchWord}%') ORDER BY Data_Info.No DESC")
    Map<String,String> getSearchResultNo(String SearchWord);

    @Select("SELECT * FROM SearchResultView WHERE No = '${No}';")
    List<Search_Result> getSearchResultByNo(Map<String,String> No);
}
