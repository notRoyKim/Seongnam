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

        // Limit 설정.. Page = 현재 위치(인덱스), NumPage = 한 번에 불러오는 데이터 수
        String Page = request.getParameter("Page");
        String NumPage = request.getParameter("NumPage");

        //JSON 반환용 Map
        Map<String,String> result = new HashMap<>();

        //결과 반환용 list
        List<Search_Result> result_list = new ArrayList<>();

        //JSON 전체 검색
        if(Page == null & NumPage == null) {
            result_list = searchService.getSearchResultNo(searchWord);
        }
        //Limit를 가지고 검색
        else if (Page != null & NumPage != null) {
            result_list = searchService.getSearchResultNoByLimit(searchWord,Integer.parseInt(Page),Integer.parseInt(NumPage));
        }

        search_result.put("Search_result",result_list);
        search_result.put("T_count",result_list.size());

        return  search_result;
    }
}
