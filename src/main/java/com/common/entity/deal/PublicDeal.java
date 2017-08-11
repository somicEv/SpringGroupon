package com.common.entity.deal;

import java.io.Serializable;

public abstract class PublicDeal implements Serializable{

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
