package com.doubtsoverflow.app.config;

import com.doubtsoverflow.app.filter.JwtAuthFilter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.doubtsoverflow.app.service.impl.JwtUserService;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtUserService jwtUserService;

	@Autowired
	private JwtAuthFilter jwtAuthFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserService);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().configurationSource(request -> {
		      var cors = new CorsConfiguration();
		      cors.setAllowedOrigins(List.of("*"));
		      cors.setAllowedMethods(List.of("*"));
		      cors.setAllowedHeaders(List.of("*"));
		      return cors;
		    });
		http.csrf()
				.disable()
				.authorizeRequests()
				.antMatchers("/user/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
