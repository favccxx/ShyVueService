package com.favccxx.shy.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.favccxx.shy.entity.ShyUser;
import com.favccxx.shy.result.PageResult;
import com.favccxx.shy.result.RestResult;
import com.favccxx.shy.service.UserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/userinfo")
@Component
@Api(value = "用户管理接口", produces = "application/json")
public class UserInfoResource {

	@Autowired
	UserInfoService userInfoService;

	@GET
	@Path("/findByUsername")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据用户名查询用户信息. Version 1 - (version in URL)")
	public RestResult<ShyUser> userName(@QueryParam(value = "userName") String userName) {
		RestResult<ShyUser> rs = new RestResult<ShyUser>();
		if (StringUtils.isBlank(userName)) {
			rs.setInvalidParams("用户名不允许为空。");
			return rs;
		}

		ShyUser shyUser = userInfoService.findByUserName(userName);
		rs.setData(shyUser);
		return rs;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pageUsers")
	public PageResult<ShyUser> pageUsers(@QueryParam(value = "searchTxt") String searchTxt,
			@QueryParam("sortField") String sortField,
			@QueryParam(value = "direction") @DefaultValue("") String direction,
			@QueryParam(value = "pageIndex") @DefaultValue("1") int pageIndex,
			@QueryParam(value = "pageSize") @DefaultValue("10") int pageSize) {
		String defaultSort = "uid";
		if (!StringUtils.isEmpty(sortField)) {
			defaultSort = sortField;
		}
		Direction directionField = Direction.DESC;
		if (direction.toUpperCase().equals("ASC")) {
			directionField = Direction.ASC;
		}

		Sort sort = new Sort(directionField, defaultSort);
		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize, sort);
		Page<ShyUser> pageData = userInfoService.pageUsers(searchTxt, pageable);
		PageResult<ShyUser> restResult = PageResult.success(pageData);

		return restResult;
	}

	// @POST
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// @Produces(MediaType.APPLICATION_JSON)
	// @Path("/register")
	// public DataResult<SysUser> login(@Null @FormParam("userName") String
	// userName, @FormParam("userPwd") String userPwd,
	// @FormParam("nickName") String nickName, @FormParam("userMail") String
	// userMail,
	// @FormParam("userMail") String userTel) {
	//
	// DataResult<SysUser> dataResult = new DataResult<SysUser>();
	//
	// if (StringUtils.isEmpty(nickName) || StringUtils.isEmpty(userPwd)) {
	// // return DataResult.
	// }
	//
	// SysUser sysUser = new SysUser();
	// sysUser.setUserName(userName);
	// sysUser.setNickName(nickName);
	// sysUser.setUserMail(userMail);
	// sysUser.setUserTel(userTel);
	// userService.saveUser(sysUser);
	//
	// return DataResult.success(sysUser);
	//
	// }

}
