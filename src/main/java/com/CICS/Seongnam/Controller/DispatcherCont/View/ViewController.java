package com.CICS.Seongnam.Controller.DispatcherCont.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView base(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("View/view");
        return mv;
    }
}
