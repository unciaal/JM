package users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listUser");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editForm");
        return modelAndView;
    }

}
