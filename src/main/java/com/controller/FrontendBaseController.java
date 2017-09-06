package com.controller;

import com.common.constant.WebConstants;

import javax.servlet.http.HttpServletResponse;

public class FrontendBaseController {

    /**
     * 生成404页面
     */
    protected String generateError404Page(HttpServletResponse response) {
        //公益信息
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return WebConstants.ERROR_PAGE_404;
    }

}
