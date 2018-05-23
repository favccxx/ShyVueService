package com.favccxx.shy.configure;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
public class JerseyConfig extends ResourceConfig {

	@Value("${spring.jersey.application-path}")
	private String apiPath;

	public JerseyConfig() {
		// CustomJacksonObjectMapper mapper = new CustomJacksonObjectMapper();
		// register(new Hibernate5Module());
		// register(RequestContextFilter.class);
		//
		// register(AuthenticationFilter.class);
		//
		// register(RolesAllowedDynamicFeature.class);

		packages("com.favccxx.shy");
	}

	@PostConstruct
	public void init() {
		this.configureSwagger();
	}

	private void configureSwagger() {
		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);
		BeanConfig config = new BeanConfig();
		config.setConfigId("springboot-jersey-swagger-docker-example");
		config.setTitle("Spring Boot + Jersey + Swagger + Docker Example");
		config.setVersion("v1");
		config.setContact("wzh");
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath(this.apiPath);
		config.setResourcePackage("com.favccxx.shy.rest");
		config.setPrettyPrint(true);
		config.setScan(true);
	}

}
