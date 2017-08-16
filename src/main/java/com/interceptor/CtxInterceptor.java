package com.interceptor;

import com.common.entity.area.Area;
import com.util.IpUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CtxInterceptor implements HandlerInterceptor {

	public static final String CONTEXT_NAME = "ctx";

	public static final String SCHEME_SUFFEX = "://";

	public static final String SEPARATE_SERVER_PORT = ":";

	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

		if (modelAndView == null || modelAndView.getModel() == null){
			return;
		}
		String areaName = request.getParameter("requestAreaName");
		if(areaName != null){
			System.out.println("查询到的城市名称：" + areaName);
			modelAndView.addObject("areaName", areaName);
		}else {
			Area area = IpUtil.getArea(request);
			if (area == null) {
				modelAndView.addObject("areaName", "找不到相关城市");
			} else {
				System.out.println("查询到的城市名称：" + area.getName());
				modelAndView.addObject("areaName", area.getName());
			}
		}

		StringBuffer ctx = new StringBuffer();
		ctx.append(request.getScheme());
		ctx.append(SCHEME_SUFFEX);
		ctx.append(request.getServerName());
		if (request.getServerPort() != 80) {
			ctx.append(SEPARATE_SERVER_PORT);
			ctx.append(request.getServerPort());
		}
		ctx.append(request.getContextPath());

		modelAndView.getModel().put(CONTEXT_NAME, ctx.toString());

		//重定向操作特殊处理
		if (modelAndView.getViewName().startsWith("redirect:")) {
			modelAndView.getModel().clear();
		}

	}

	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
