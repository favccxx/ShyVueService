package com.favccxx.shy.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ShyResource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long resourceId;

	/**
	 * 资源名称
	 */
	private String resourceName;

	/**
	 * 资源类型：菜单/按钮
	 */
	@Column(columnDefinition = "enum('menu','button')")
	private String resourceType;

	/**
	 * 资源地址
	 */
	private String resourceUrl;

	/**
	 * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
	 */
	private String permission;

	/**
	 * 父资源Id
	 */
	private Long parentId;

	/**
	 * 父资源Id列表
	 */
	private String parentIds; // 父编号列表

	/**
	 * 是否允许操作
	 */
	private Boolean available = Boolean.FALSE;

	@ManyToMany
	@JoinTable(name = "ShyRoleResource", joinColumns = { @JoinColumn(name = "resourceId") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })
	private List<ShyRole> roles;

	

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public List<ShyRole> getRoles() {
		return roles;
	}

	public void setRoles(List<ShyRole> roles) {
		this.roles = roles;
	}

}
