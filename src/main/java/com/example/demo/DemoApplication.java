package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Collections;
import java.util.stream.Stream;

@SpringBootApplication()
//@SecurityScheme(name = "basicScheme", type = SecuritySchemeType.HTTP,
//scheme="basic" )
public class DemoApplication implements ApplicationRunner {

	@Autowired
	private HeroesRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Heroes h = new Heroes();
		h.setNombre("Aquaman");
		h.setBio("El poder");
		h.setImg("assets/img/aquaman.png");
		h.setAparicion(LocalDate.of(1941, 11, 01));
		h.setCasa("DC");
		repo.save(h);

		h = new Heroes();
		h.setNombre("Batman");
		h.setBio("Los rasgos");
		h.setImg("assets/img/batman.png");
		h.setAparicion(LocalDate.of(1939, 05, 01));
		h.setCasa("DC");
		repo.save(h);

		h = new Heroes();
		h.setNombre("Hulk");
		h.setBio("Su principal poder");
		h.setImg("assets/img/hulk.png");
		h.setAparicion(LocalDate.of(1962, 05, 01));
		h.setCasa("Marvel");
		repo.save(h);
	}

	// @Bean
	// public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
	// UrlBasedCorsConfigurationSource source = new
	// UrlBasedCorsConfigurationSource();
	// CorsConfiguration config = new CorsConfiguration();
	// config.setAllowCredentials(true);
	// config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
	// config.setAllowedMethods(Collections.singletonList("*"));
	// config.setAllowedHeaders(Collections.singletonList("*"));
	// source.registerCorsConfiguration("/**", config);
	// FilterRegistrationBean<CorsFilter> bean = new
	// FilterRegistrationBean<>(new CorsFilter(source));
	// bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	// return bean;
	// }
}
