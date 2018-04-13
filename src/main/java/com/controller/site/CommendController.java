package com.controller.site;

import com.common.entity.Commend;
import com.common.entity.deal.Deal;
import com.common.entity.user.WebUser;
import com.common.vo.QueryMessage;
import com.controller.common.FrontendBaseController;
import com.service.business.CommendBusiness;
import com.service.business.DealBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/commend")
public class CommendController extends FrontendBaseController {

    private Logger log = LoggerFactory.getLogger(CommendController.class);

    @Autowired
    DealBusiness dealBusiness;

    @Autowired
    CommendBusiness commendBusiness;

    @RequestMapping(value = "/index/{skuId}")
    public String showCommend(@PathVariable Long skuId, Model model, HttpServletRequest request) {
        WebUser currentUser = this.getCurrentUser(request);
        model.addAttribute("userInfo", currentUser);
        Deal dealBySkuId = dealBusiness.getDealBySkuId(skuId);
        model.addAttribute("dealInfo", dealBySkuId);
        //
        return "/layout/commend";
    }

    @RequestMapping(value = "/add")
    public String test(Commend commend, HttpServletRequest request, Model model) {
        log.info("[CommendController]add-->{}", commend);
        // 拿到当前用户
        WebUser currentUser = this.getCurrentUser(request);
        // 补全信息
        commend.setUserId(currentUser.getUserId().intValue());
        QueryMessage queryMessage = commendBusiness.addNewCommend(commend);
        if ("500".equals(queryMessage.getQueryCode())) {
            model.addAttribute("result", 0);
            return "/layout/commend";
        }
        model.addAttribute("result", 1);
        return "redirect:/commend/index/" + commend.getSkuId();
    }
}
