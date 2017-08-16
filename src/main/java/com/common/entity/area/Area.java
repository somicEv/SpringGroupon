package com.common.entity.area;


import java.util.Date;
import java.util.List;

public class Area {

	private Long id;
	private String name;
    private Long parentId;
    private Integer common;//常用
	private AreaType type;//类型:省,市
	private Date createTime;
	private Date updateTime;

	private List<Area> children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getCommon() {
		return common;
	}

	public void setCommon(Integer common) {
		this.common = common;
	}

	public AreaType getType() {
		return type;
	}

	public void setType(AreaType type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<Area> getChildren() {
		return children;
	}

	public void setChildren(List<Area> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Area{" +
				"id=" + id +
				", name='" + name + '\'' +
				", parentId=" + parentId +
				", common=" + common +
				", type=" + type +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}
}
