package com.interceptor;

import com.common.entity.user.WebUser;
import com.util.CookieUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // 将用户信息存入Cookie
        WebUser loginUser = CookieUtil.getLoginUser(httpServletRequest);
        if (loginUser != null) {
            CookieUtil.setLoginUser(httpServletResponse, loginUser);
        }
        // 设置用户名称
        if (modelAndView != null && loginUser != null && !StringUtils.isEmpty(loginUser.getUsername())){
            modelAndView.addObject("username", loginUser.getUsername());
        }
        if (null != modelAndView && modelAndView.getViewName().startsWith("redirect:")) {
            modelAndView.getModel().clear();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
