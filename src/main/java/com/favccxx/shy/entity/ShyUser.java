package com.favccxx.shy.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShyUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
    private Long uid;
	
    @Column(unique =true)
    private String userName;//帐号
    
    private String nickName;

    private String password; 
    
    private String salt;
    
    private byte state;
    
    @JsonIgnore
    @ManyToMany(targetEntity=ShyRole.class, fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "ShyUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<ShyRole> roleList;// 一个用户具有多个角色

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public List<ShyRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<ShyRole> roleList) {
		this.roleList = roleList;
	}
    
	/**
	 * 密码盐
	 * @return
	 */
	public String getCredentialsSalt() {
		return this.userName + this.salt;
	}
    

}
