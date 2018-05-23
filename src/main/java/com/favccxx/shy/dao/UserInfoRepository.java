package com.favccxx.shy.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.favccxx.shy.entity.ShyUser;

public interface UserInfoRepository extends CrudRepository<ShyUser, Long> {

	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	ShyUser findByUserName(String userName);
	
	
	 @Query( value = "from ShyUser su", 
			 countQuery = " select count(su) from ShyUser su" )  
	Page<ShyUser> pageUsers(String userName, String nickName, Pageable pageable);
}
