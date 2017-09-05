package com.controller.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

    @RequestMapping(value = "/item/{skuId}",method = RequestMethod.GET)
    public String dealDetail(){
        return "/deal/detail";
    }

}
