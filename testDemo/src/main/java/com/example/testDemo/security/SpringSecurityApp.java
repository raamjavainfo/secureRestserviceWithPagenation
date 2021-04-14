package com.example.testDemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SpringSecurityApp extends WebSecurityConfigurerAdapter{
	
	// authentication
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication()
			.withUser("test")
			.password("password")
			.roles("Test")
			.and()
			.withUser("admin")
			.password("admin")
			.roles("admin");
			
		}
		
		//authorization
		protected void configure(HttpSecurity http) throws Exception {
			
			http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
			http.formLogin();
			http.httpBasic();
		}

		@Bean
		public PasswordEncoder getPasswordEncoder() {
			return NoOpPasswordEncoder.getInstance();
		}
}
