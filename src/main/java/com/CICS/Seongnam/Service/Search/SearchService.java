package com.CICS.Seongnam.Service.Search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchMapper searchMapper;

    public List<String> getSearchResultNo(String Searchword) {
        return searchMapper.getSearchResultNo(Searchword);
    }


}
