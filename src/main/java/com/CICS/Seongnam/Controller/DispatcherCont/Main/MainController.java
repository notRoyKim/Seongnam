package com.CICS.Seongnam.Controller.DispatcherCont.Main;

import com.CICS.Seongnam.Domain.ViewData;
import com.CICS.Seongnam.Service.Main.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView base(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Main/Base");

        List<ViewData> viewDataList = mainService.getMainRandSlider();

        mv.addObject("viewDataList",viewDataList);
        return mv;
    }
}
