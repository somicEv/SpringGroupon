package com.common.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class WebUser {

	private Long userId;

	private String username;

	private int loginStatus;


}
