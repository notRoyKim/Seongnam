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
    public String searchJSON(HttpServletRequest request) {

        String JSON = "?(";

        Map<String, Object> search_result = new HashMap<>();

        String searchWord = request.getParameter("query");

        Map<String,String> result = new HashMap<>();

        List<Search_Result> result_list = new ArrayList<>();
        result_list = searchService.getSearchResultNo(searchWord);

        search_result.put("Search_result",result_list);
        search_result.put("T_count",'[' + Integer.toString(result_list.size()) + ']');

        JSON = JSON + search_result + ')';

        return JSON;
    }
}
