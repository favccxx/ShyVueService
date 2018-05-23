package com.favccxx.shy.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.favccxx.shy.service.UserInfoService;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
	
	@Autowired
	UserInfoService userInfoService;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String[] excludeUrls = {"login", "logout"};
		boolean flag = false;
		for(String url : excludeUrls) {
			if(requestContext.getUriInfo().getPath().contains(url)) {
				flag = true;
				continue;
			}
		}
		
		
		if(!flag) {
			String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

			// Validate the Authorization header
			if (!checkTokenAuthorization(authorizationHeader)) {
				abortWithUnauthorized(requestContext);
				return;
			}
		}
		
		String scheme = requestContext.getUriInfo().getRequestUri().getScheme();
		System.out.println(scheme);
		
		
//		AuthUser authUser = userService.getUserInfo("lisi");
		SecurityContextAuthorization sc = new SecurityContextAuthorization(null);
		requestContext.setSecurityContext(sc);
		

		// Extract the token from the Authorization header
		//String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();

		try {

			// Validate the token
			//validateToken(token);

		} catch (Exception e) {
			abortWithUnauthorized(requestContext);
		}

	}
	
	
	private boolean checkTokenAuthorization(String authorizationHeader) {
		
		if (authorizationHeader != null) {
			return true;
		}
		return true;
	}

	private void abortWithUnauthorized(ContainerRequestContext requestContext) {		
		requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
				.header(HttpHeaders.WWW_AUTHENTICATE, "CCCCC").build());
	}

}
