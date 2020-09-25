package com.CICS.Seongnam.Controller.DispatcherCont.Main;

import com.CICS.Seongnam.Service.Main.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    MainService mainService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView base(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Main/Base");

        List<String> all_id = new ArrayList<>();
        //all_id = mainService.getallArchivesID();

        System.out.println(mainService.getallArchivesID());

        /*
        String[] all_id = mainService.getallArchivesID();
        String[] Selected_rand_id = new String[5];
        int id_count = all_id.length;

        for(int i = 0; i < 4 ; i ++) {
            int rand = (int)(Math.random() * id_count);
            Selected_rand_id[i] = all_id[rand];
            System.out.println(Selected_rand_id);
        }
        */

        return mv;
    }
}
