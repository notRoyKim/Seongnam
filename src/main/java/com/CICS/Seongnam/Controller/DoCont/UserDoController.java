package com.CICS.Seongnam.Controller.DoCont;

import com.CICS.Seongnam.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class UserDoController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login_process", method = RequestMethod.POST)
    public ModelAndView login_Process(ModelAndView mv , HttpServletRequest request, HttpServletResponse response) throws IOException {

        mv.setViewName("Main/BASE");

        try {
            HttpSession session = request.getSession();
            String ID = request.getParameter("ID");
            String PW = request.getParameter("PW");

            String userInfo = userService.loginUser(ID, PW);

            if(userInfo != null) {
                session.setAttribute("ID",userInfo);
            }

            mv.addObject("session", session);

            return new ModelAndView("redirect:/");
        }
        catch (Exception e) {

            ModelAndView modelAndView = new ModelAndView("redirect:/network_login");

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response.getWriter();

            out_equals.println("<script>alert('Login Failed! Invalid ID and/or Password, Please try again');location.href='/network_login';</script>");

            out_equals.flush();
            return modelAndView;
        }
    }
}
