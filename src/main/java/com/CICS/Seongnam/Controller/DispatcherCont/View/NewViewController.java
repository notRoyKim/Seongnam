package com.CICS.Seongnam.Controller.DispatcherCont.View;

import com.CICS.Seongnam.Domain.View_Data_Info;
import com.CICS.Seongnam.Domain.View_Gusul_Info;
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
public class NewViewController {

    @Autowired
    private ViewService viewService;

    @RequestMapping(value = "/view2", method = RequestMethod.GET)
    public ModelAndView view2(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        try {

            String No = request.getParameter("No");

            View_Data_Info view_data_info;
            View_Gusul_Info view_Gusul_info;
            List<View_Data_Info> DataInfoList = new ArrayList<>();
            List<View_Gusul_Info> GusulInfoList = new ArrayList<>();

            if(No == null){
                mv.setViewName("redirect:/");
                return mv;
            }

            System.out.println(No);

            //viewdata ( archive 뷰의 메타데이터를 갖고있는 class ViewData)
            view_data_info = viewService.getViewDataInfo(No);

            System.out.println(view_data_info.getNo());

            //viewdata가 비어있다면 = getArchives로 Select한 결과가 없다면 404.html로 에러처리
            if(ObjectUtils.isEmpty(view_data_info)){
                mv.setViewName("ErrorControl/404");
                return mv;
            }

            view_Gusul_info = viewService.getViewGusulInfo(view_data_info.getName_NO());

            GusulInfoList.add(view_Gusul_info);
            DataInfoList.add(view_data_info);

            String Media = viewService.getFilesByDataNo(No);
            System.out.println(Media);

            String[] Media_Path = Media.split(",");
            String Media_html = "";

            for(int i = 0 ; i < Media_Path.length ; i++) {
                Media_html = Media_html + "<div><img data-u=\"image\" src=\"/Image/" + Media_Path[i] + "\" /></div>";
            }


            mv.setViewName("View/view");
            mv.addObject("DataInfoList",DataInfoList);
            mv.addObject("gusulInfoList",GusulInfoList);
            mv.addObject("Media_html",Media_html);
            return mv;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}
