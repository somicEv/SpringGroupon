package com.controller.site;

import com.common.vo.NewspaperDTO;
import com.service.business.NewspaperBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class NewspaperController {

    private Logger log = LoggerFactory.getLogger(NewspaperController.class);

    @Autowired
    NewspaperBusiness newspaperBusiness;

    @RequestMapping(value = "/newspaper/index")
    public String show(Model model) {
        // 查询报刊列表
        List<NewspaperDTO> newspaperList = newspaperBusiness.getNewspaperList();
        log.info("[NewspaperController]show-->newspaperList:{}",newspaperList);
        model.addAttribute("newspaperList", newspaperList);
        return "/layout/newsPaper";
    }

}
