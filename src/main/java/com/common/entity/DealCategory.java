package com.common.entity;

public class DealCategory {

	private String id;
	private String parent_id;
	private String name;
	private String url_name;
	private Integer publish_status;
	private String create_time;
	private Integer order_num;
	private Integer deep;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
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

	public Integer getpublish_status() {
		return publish_status;
	}

	public void setpublish_status(Integer publish_status) {
		this.publish_status = publish_status;
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
