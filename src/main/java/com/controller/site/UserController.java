package com.controller.site;

import com.common.constant.WebConstants;
import com.common.entity.user.User;
import com.common.entity.user.WebUser;
import com.groupon.user.business.UserBusiness;
import com.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@Controller
public class UserController {

	@Autowired
	private UserBusiness userBusiness;

	@RequestMapping(value = "/login")
	public String login(){
		return "/user/login";
	}

	@RequestMapping(value = "/reg")
	public String register(){
		return "/user/register";
	}

	@RequestMapping(value = "/dologin")
	public String doLogin(User user,HttpServletResponse response,Model model){
		// 在数据库中查找
		User resultUser = userBusiness.dologin(user);
		if(resultUser == null){
			return "redirect:/login";
		}
		// 存入Cookie
		WebUser webuser = new WebUser();
		webuser.setUserId(resultUser.getId().longValue());
		webuser.setUsername(resultUser.getName());
		webuser.setLoginStatus(WebConstants.USER_LOGIN_STATUS_NORMAL);
		CookieUtil.setLoginUser(response,webuser);
		// 更新用户信息
		User userTemplate = new User();
		userTemplate.setId(resultUser.getId());
		userTemplate.setLoginTime(new Date());
		return "redirect:/index.html";
	}

	@RequestMapping(value = "/register")
	public String doRegister(User user, HttpServletResponse response, Model model){
		// 查询数据库
		boolean result = userBusiness.doRegister(user);
		if (!result){
			return "redirect:/reg";
		}
		// 存入Cookie
		WebUser webuser = new WebUser();
		webuser.setUsername(user.getName());
		webuser.setLoginStatus(WebConstants.USER_LOGIN_STATUS_NORMAL);
		CookieUtil.setLoginUser(response,webuser);
		return "redirect:/index.html";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletResponse response){
		CookieUtil.removeCookie(response,"ui","/");
		return "index.html";
	}
}
