package com.CICS.Seongnam.Controller.DispatcherCont.View;

import com.CICS.Seongnam.Domain.ViewData;
import com.CICS.Seongnam.Service.View.ViewService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ViewController {

    @Autowired
    private ViewService viewService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView base(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        try {
            String articleID = request.getParameter("id");

            ViewData viewData;
            List<ViewData> viewDataList = new ArrayList<>();

            //get 해온 id값이 없으면
            if(articleID == "") {
                mv.setViewName("redirect:/");
                return mv;
            }

            viewData = viewService.getArchives(articleID);
            viewDataList.add(viewData);

            mv.setViewName("View/view");
            mv.addObject("viewDataList",viewDataList);
            return mv;
        }
        catch (Exception e) {

        }
        return mv;
    }
}
