package com.controller.common;

import com.common.constant.WebConstants;
import com.common.entity.user.WebUser;
import com.util.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontendBaseController {

    /**
     * 生成404页面
     * @param response
     * @return
     */
    protected String generateError404Page(HttpServletResponse response) {
        //公益信息
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return WebConstants.ERROR_PAGE_404;
    }

    /**
     * 生成500页面
     * @param response
     * @return
     */
    protected String generateError500Page(HttpServletResponse response) {
        //公益信息
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return WebConstants.ERROR_PAGE_500;
    }

    /**
     * 获取当前登录用户
     * @param request
     * @return
     */
    protected WebUser getCurrentUser(HttpServletRequest request){
        return CookieUtil.getLoginUser(request);
    }

}
