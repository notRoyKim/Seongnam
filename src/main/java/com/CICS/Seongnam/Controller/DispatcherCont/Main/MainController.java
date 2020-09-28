package com.CICS.Seongnam.Controller.DispatcherCont.Main;

import com.CICS.Seongnam.Service.Main.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView base(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Main/Base");

        String[] all_id = mainService.getallArchivesID();
        Random rand = new Random();

        List<String> SelectedID = new ArrayList<>();
        String[] randomID = new String[4];

        for(int i = 0; i < 4 ; i++) {
            String temp = all_id[rand.nextInt(all_id.length)];
            randomID[i] = temp;

            for(int j = 0; j < i; j++) {
                if(randomID[j] == temp) {
                    i--;
                }
            }
        }

        for(int i = 0; i < 4; i++) {
            SelectedID.add(randomID[i]);
        }

        return mv;
    }
}
