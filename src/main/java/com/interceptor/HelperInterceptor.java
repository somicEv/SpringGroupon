package com.interceptor;

import com.helper.ImageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelperInterceptor implements HandlerInterceptor {

	@Autowired
	private ImageHelper imageHelper;

	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		return true;
	}

	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
		System.out.println("通过拦截器");
		if (null == modelAndView || null == modelAndView.getModel() ) {
			return;
		}
		modelAndView.getModel().put("helper", imageHelper);
	}

	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
