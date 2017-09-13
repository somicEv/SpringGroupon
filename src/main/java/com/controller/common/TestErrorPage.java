package com.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class TestErrorPage extends FrontendBaseController{

    @RequestMapping(value = "/404")
    public String test404Page(HttpServletResponse response){
        return this.generateError404Page(response);
    }

    @RequestMapping(value = "/500")
    public String test505Page(HttpServletResponse response){
        return this.generateError500Page(response);
    }
}
