package com.CICS.Seongnam.Service.Search;

import com.CICS.Seongnam.Domain.Search_Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {

    @Autowired
    private SearchMapper searchMapper;

    public Map<String,String> getSearchResultNo(String Searchword) {

        Map<String, String> ret_result = new HashMap<>();

        List<String> sear_result = searchMapper.getSearchResultNo(Searchword);

        for (int i = 0; i < sear_result.size(); i++) {
            ret_result.put(Integer.toString(i),sear_result.get(i));
        }

        return ret_result;
    }

    public List<Search_Result> getSearchResultByNo(Map<String,String> No) { return searchMapper.getSearchResultByNo(No);}


}
