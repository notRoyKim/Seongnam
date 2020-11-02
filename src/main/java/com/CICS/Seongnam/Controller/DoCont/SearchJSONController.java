package com.CICS.Seongnam.Controller.DoCont;

import com.CICS.Seongnam.Domain.Search_Result;
import com.CICS.Seongnam.Service.Search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchJSONController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/Search_JSON", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchJSON(HttpServletRequest request) {

        Map<String, Object> search_result = new HashMap<>();

        String searchWord = request.getParameter("query");

        List<String> result = new ArrayList<>();
        result = searchService.getSearchResultNo(searchWord);

        List<Search_Result> result2 = new ArrayList<>();
        result2 = searchService.getSearchResultByNo(result);

        System.out.println(result2.size());

        return  search_result;
    }
}
