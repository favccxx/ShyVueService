package com.favccxx.shy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.favccxx.shy.entity.ShyUser;

public interface UserInfoService {

	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	ShyUser findByUserName(String userName);
	
	/**
	 * 分页查询用户信息
	 * @param searchTxt
	 * @param pageable
	 * @return
	 */
	Page<ShyUser> pageUsers(String searchTxt, Pageable pageable);

	/**
	 * 保存用户
	 * 
	 * @param ShyUser
	 */
	void saveUser(ShyUser user);

}
