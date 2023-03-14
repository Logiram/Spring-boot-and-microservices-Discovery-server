package com.codefreak.discoveryserver.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
public void configure(AuthenticationManagerBuilder auth)throws Exception{
		
	System.out.println("inside eureka authn");
	auth.inMemoryAuthentication()
		.passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("eureka").password("password")
		.authorities("USER");
	}
	
	@Override
public void configure(HttpSecurity http) throws Exception{
	
	http.csrf().disable()
	.authorizeRequests().anyRequest()
	.authenticated()
	.and()
	.httpBasic();
}
	
	
}
