package com.CICS.Seongnam.Service.Search;

import com.CICS.Seongnam.Domain.Search_Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {

    @Autowired
    private SearchMapper searchMapper;
    //전체 검색
    public List<Search_Result> getSearchResultNo(String Searchword) {

        List<Search_Result> ret_result = new ArrayList<>();

        List<String> sear_result = searchMapper.getSearchResultNo(Searchword);

        for (int i = 0; i < sear_result.size(); i++) {
            Search_Result temp = searchMapper.getSearchResultByNo(sear_result.get(i));
            ret_result.add(temp);
        }

        return ret_result;
    }
    //리미트를 둔 검색
    public List<Search_Result> getSearchResultNoByLimit(String Searchword, int Page, int NumPage) {

        List<Search_Result> ret_result = new ArrayList<>();

        List<String> sear_result = searchMapper.getSearchResultNoByLimit(Searchword,Page * NumPage,NumPage);

        for (int i = 0; i < sear_result.size(); i++) {
            Search_Result temp = searchMapper.getSearchResultByNo(sear_result.get(i));
            temp.setFiles(temp.getFiles().split(",")[0]);
            ret_result.add(temp);
        }

        return ret_result;
    }
}
