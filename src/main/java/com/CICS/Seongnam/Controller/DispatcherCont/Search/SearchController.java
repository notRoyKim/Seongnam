package com.CICS.Seongnam.Controller.DispatcherCont.Search;

import com.CICS.Seongnam.Domain.Main_Rand_Slide;
import com.CICS.Seongnam.Domain.Search_Result;
import com.CICS.Seongnam.Service.Search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/SearchResult", method = RequestMethod.GET)
    public ModelAndView searchResult(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();

        String query = request.getParameter("query");

        //기존 소스 구조가 조금 비효율적임.. 추후에 알고리즘을 수정할 필요가 있음.
        List<Search_Result> result_list = new ArrayList<>();
        result_list = searchService.getSearchResultNo(query);
        int result_count = result_list.size();

        mv.setViewName("Search/SearchResult");
        mv.addObject("query",query);
        mv.addObject("result_list",result_list);
        mv.addObject("result_count",result_count);
        return mv;
    }
}
