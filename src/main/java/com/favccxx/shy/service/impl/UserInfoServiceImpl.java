package com.favccxx.shy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.favccxx.shy.dao.UserInfoRepository;
import com.favccxx.shy.entity.ShyUser;
import com.favccxx.shy.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	UserInfoRepository userInfoRepository;

	@Override
	public ShyUser findByUserName(String userName) {
		return userInfoRepository.findByUserName(userName);
	}
	
	@Override
	public Page<ShyUser> pageUsers(String searchTxt, Pageable pageable) {
		String searchValue = "%" + searchTxt + "%";
		return userInfoRepository.pageUsers(searchValue, searchValue, pageable);
	}

	@Override
	public void saveUser(ShyUser user) {
		userInfoRepository.save(user);
	}

	

}
