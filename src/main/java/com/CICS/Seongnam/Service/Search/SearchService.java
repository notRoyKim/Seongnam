package com.CICS.Seongnam.Service.Search;

import com.CICS.Seongnam.Domain.Search_Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {

    @Autowired
    private SearchMapper searchMapper;

    public Map<String,String> getSearchResultNo(String Searchword) { return searchMapper.getSearchResultNo(Searchword); }

    public List<Search_Result> getSearchResultByNo(Map<String, String> No) { return searchMapper.getSearchResultByNo(No);}


}
