package com.common.entity.user;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserBasicInfo {

	private Integer id;

    private Integer userId;

    private String nickname;//昵称

	private String realName;//真实姓名

	private String mail;//邮箱

	private String phone;//电话

	private Date createTime;

	private Date updateTime;


}
