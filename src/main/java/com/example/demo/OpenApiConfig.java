package com.example.demo;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class OpenApiConfig {
	@Value("security.oauth2.client.access-token-uri")
	private String accesTokenUri;
	@Value("security.oauth2.client.user-authorization-uri")
	private String userAuthorizationUri;
	@Value("security.oauth2.client.client-secret")
	private String clientSecret;
	@Value("security.oauth2.client.client-id")
	private String clientId;

	@Bean
	public Docket postsEventApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api-person").apiInfo(apiInfo()).select()
				.paths(PathSelectors.any()).build().securitySchemes(Arrays.asList(securityScheme()))
				.securityContexts(Arrays.asList(securityContext()));
	}

		private SecurityContext securityContext() {
		return SecurityContext.builder()
		  .securityReferences(
			Arrays.asList(new SecurityReference("spring_oauth", scopes())))
		  .forPaths(PathSelectors.any())
		  .build();
	}

	private SecurityScheme securityScheme() {
		GrantType grantType = new AuthorizationCodeGrantBuilder()
			.tokenEndpoint(new TokenEndpoint(accesTokenUri, "oauthtoken"))
			.tokenRequestEndpoint(
			  new TokenRequestEndpoint(userAuthorizationUri, clientId, clientSecret))
			.build();
	 
		SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
			.grantTypes(Arrays.asList(grantType))
			.scopes(Arrays.asList(scopes()))
			.build();
		return oauth;
	}

	private AuthorizationScope[] scopes() {
		AuthorizationScope[] scopes = { 
		  new AuthorizationScope("read", "for read operations"), 
		  new AuthorizationScope("write", "for write operations"), 
		  new AuthorizationScope("openid", "Access foo API") };
		return scopes;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API BACKEND TEST SCOPE APIGEE KEYCLOAK").description("api pour gérer les scopes keycloak apigee")
				.termsOfServiceUrl("http://localhost:8888").license("OPEN API TEST SCOPE APIGEE KEYCLOAK")
				.licenseUrl("http://younes-lab.fr").version("1.0").build();
	}
}
