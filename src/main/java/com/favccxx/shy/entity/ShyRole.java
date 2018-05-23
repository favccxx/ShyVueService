package com.favccxx.shy.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 角色表
 * 
 * @author favccxx
 *
 */
@Entity
public class ShyRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long roleId;


	 /**
	 * 角色代码
	 */
	 private String roleCode;
	
	 /**
	 * 角色名称
	 */
	 private String roleName;
	
	
	 /**
	 * 角色描述
	 */
	 private String description;
	
	 /**
	 * 角色是否可用
	 *
	 * 不可用的话，用户不允许添加
	 */
	 private Boolean available = Boolean.FALSE;
	
	 /**
	 * 角色与权限之间的关系多对多
	 * 一个角色有多个权限
	 */
	 @ManyToMany(targetEntity=ShyResource.class, fetch= FetchType.EAGER)
	 @JoinTable(name="ShyRoleResource",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="resourceId")})
	 private List<ShyResource> resourceList;

	/**
	 * 用户与角色之间的关系多对多 一个角色对应多个用户
	 */
	@ManyToMany(targetEntity=ShyUser.class)
	@JoinTable(name = "ShyUserRole", joinColumns = { @JoinColumn(name = "roleId") }, inverseJoinColumns = {
			@JoinColumn(name = "uid") })
	private List<ShyUser> userList;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public List<ShyResource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<ShyResource> resourceList) {
		this.resourceList = resourceList;
	}

	public List<ShyUser> getUserList() {
		return userList;
	}

	public void setUserList(List<ShyUser> userList) {
		this.userList = userList;
	}

	

}
