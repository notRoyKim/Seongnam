package com.CICS.Seongnam.Service.Search;

import com.CICS.Seongnam.Domain.Search_Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.SearchResult;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchMapper searchMapper;

    public List<String> getSearchResultNo(String Searchword) {
        return searchMapper.getSearchResultNo(Searchword);
    }

    public List<Search_Result> getSearchResultByNo(List<String> No) {
        return searchMapper.getSearchResultByNo(No);
    }


}
