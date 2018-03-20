package com.util;

import com.common.entity.user.WebUser;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Objects;


/**
 * Cookie工具类
 */
public class CookieUtil {
    /**
     * 默认Cookie过期时间（单位：秒）
     */
    public static final int MAX_AGE = 60 * 30;

    /**
     * 用户登陆信息Cookie名字
     */
    public static final String USER_INFO = "ui";

    /**
     * 向Cookie中写入用户信息
     *
     * @param response
     * @param user
     */
    public static void setLoginUser(HttpServletResponse response, WebUser user) {
        if (null == response || null == user) {
            return;
        }
        Long userId = user.getUserId();
        String username = user.getUsername();
        try {
            username = URLEncoder.encode(user.getUsername(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder cookieValue = new StringBuilder();
        cookieValue.append(userId).append("|").append(username).append("|").append(user.getLoginStatus());
        System.out.println(cookieValue);
        addCookie(response, USER_INFO, cookieValue.toString());

    }

    /**
     * 添加Cookie
     *
     * @param response
     * @param name
     * @param value
     */
    public static void addCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(MAX_AGE);
        response.addCookie(cookie);
    }

    /**
     * 从Cookie中获取用户信息
     *
     * @param request
     * @return
     */
    public static WebUser getLoginUser(HttpServletRequest request) {
        if (null == request) {
            return null;
        }

        //从cookie里取出用户信息(三个字段)
        String value = getCookieValue(USER_INFO, request);
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        String[] array = value.split("\\|");

        WebUser user = new WebUser();

        try {
            user.setUserId(Long.parseLong(array[0]));
            user.setUsername(URLDecoder.decode(array[1], "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            user.setUsername(array[1]);
        }
        user.setLoginStatus(Integer.parseInt(array[2]));
        return user;
    }

    /**
     * 根据Cookie名称获取相应的值
     *
     * @param name
     * @param request
     * @return
     */
    public static String getCookieValue(String name, HttpServletRequest request) {
        if (null == request || StringUtils.isEmpty(name)) {
            return null;
        }

        Cookie[] cookies = request.getCookies();
        if (null == cookies || 0 == cookies.length) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (Objects.equals(cookie.getName(), name)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    /**
     * 删除Cookie
     *
     * @param response HttpServletResponse
     * @param name     Cookie名
     * @param path     Cookie Path
     */
    public static void removeCookie(HttpServletResponse response, HttpServletRequest request, String name, String path) {
        if (null == response || StringUtils.isEmpty(name) || StringUtils.isEmpty(path)) {
            return;
        }
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            System.out.println("cookie 为空");
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue(null);
                    cookie.setPath(path);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }

}