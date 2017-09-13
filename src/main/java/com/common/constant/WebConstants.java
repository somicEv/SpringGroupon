package com.common.constant;

/**
 * Web常量
 */
public final class WebConstants {

	// ------错误页面------
	public static final String ERROR_PAGE_404 = "/common/error/404";

	public static final String ERROR_PAGE_500 = "/common/error/500";

	// ------用户登陆状态------
	/** 未登录 */
	public static final int USER_LOGIN_STATUS_NO = 0;
	/** 登录 */
	public static final int USER_LOGIN_STATUS_NORMAL = 1;
	/** 安全登录 */
	public static final int USER_LOGIN_STATUS_SECURITY = 2;
	
	// ------用户默认头像------
	// public static final String DEFAULT_HEAD_IMG_URL = "/images/default_head_img.png";
	
	// ------短信发送方网站------
	public static final String SMS_CODE_SENDER_SITE = "site";
	
	// ------短信发送方App------
	public static final String SMS_CODE_SENDER_APP = "app";
}