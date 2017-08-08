package com.common.entity;

import java.util.List;

public class DealCategory {

	private Integer id;
	private String name;
	private Integer parent_id;
	private String url_name;
	private Integer publish_status;
	private String create_time;
	private Integer order_num;
	private Integer deep;
	private List<DealCategory> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl_name() {
		return url_name;
	}

	public void setUrl_name(String url_name) {
		this.url_name = url_name;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public Integer getOrder_num() {
		return order_num;
	}

	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}

	public Integer getDeep() {
		return deep;
	}

	public void setDeep(Integer deep) {
		this.deep = deep;
	}

	public Integer getPublish_status() {
		return publish_status;
	}

	public void setPublish_status(Integer publish_status) {
		this.publish_status = publish_status;
	}

	public List<DealCategory> getChildren() {
		return children;
	}

	public void setChildren(List<DealCategory> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "DealCategory{" +
				"id='" + id + '\'' +
				", parent_id='" + parent_id + '\'' +
				", name='" + name + '\'' +
				", url_name='" + url_name + '\'' +
				", public_status=" + publish_status +
				", create_time='" + create_time + '\'' +
				", order_num=" + order_num +
				", deep=" + deep +
				'}';
	}
}
