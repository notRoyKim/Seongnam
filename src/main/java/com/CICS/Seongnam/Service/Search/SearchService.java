package com.CICS.Seongnam.Service.Search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private SearchMapper searchMapper;

    public String getSearchResultNo(String Searchword) {
        return getSearchResultNo(Searchword);
    }
}
