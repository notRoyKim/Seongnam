package com.CICS.Seongnam.Controller.DispatcherCont.View;

import com.CICS.Seongnam.Domain.ViewData;
import com.CICS.Seongnam.Service.View.ViewService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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


            //GET METHOD NOT USED, then return to main page
            if(articleID == null){
                mv.setViewName("redirect:/");
                return mv;
            }


            //viewdata ( archive 뷰의 메타데이터를 갖고있는 class ViewData)
            viewData = viewService.getArchives(articleID);


            //viewdata가 비어있다면 = getArchives로 Select한 결과가 없다면 404.html로 에러처리
            if(ObjectUtils.isEmpty(viewData)){
                mv.setViewName("ErrorControl/404");
                return mv;
            }

            viewDataList.add(viewData);

            String Media = viewData.getContent_Media();
            String[] Media_Path = Media.split(",");
            String Media_html = "";

            for(int i = 0 ; i < Media_Path.length ; i++) {
                Media_html = Media_html + "<div><img data-u=\"image\" src=\"/Image/" + Media_Path[i] + "\" /></div>";
            }

            mv.setViewName("View/view");
            mv.addObject("viewDataList",viewDataList);
            mv.addObject("Media_html",Media_html);
            return mv;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}
