package com.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 查询条件
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Condition implements Serializable {

	/**
	 * 参数名称
	 */
	private String name;

	/**
	 * 参数值
	 */
	private Object value;
}