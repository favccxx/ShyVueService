package com.favccxx.shy.filter;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import com.favccxx.shy.entity.ShyUser;

public class SecurityContextAuthorization implements SecurityContext {

	private ShyUser shyUser;

	public SecurityContextAuthorization(ShyUser shyUser) {
		this.shyUser = shyUser;
	}

	@Override
	public Principal getUserPrincipal() {
		return (Principal) this.shyUser;
	}

	@Override
	public boolean isUserInRole(String role) {
		if (role != null) {
//			return shyUser.getRoles().contains(role);
		}
		return false;
	}

	@Override
	public boolean isSecure() {
		return false;
	}

	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}

}
