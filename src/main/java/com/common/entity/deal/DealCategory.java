package com.common.entity.deal;

import lombok.Data;

import java.util.List;

@Data
public class DealCategory extends PublicDeal {

	private String name;
	private Long parent_id;
	private String url_name;
	private Integer publish_status;
	private String create_time;
	private Integer order_num;
	private Integer deep;
	private List<DealCategory> children;

	@Override
	public String toString() {
		return "DealCategory{" +
				"id='" + super.getId() + '\'' +
				", parent_id='" + parent_id + '\'' +
				", name='" + name + '\'' +
				", url_name='" + url_name + '\'' +
				", public_status=" + publish_status +
				", create_time='" + create_time + '\'' +
				", order_num=" + order_num +
				", deep=" + deep + ", children=" + children +
				'}';
	}
}
