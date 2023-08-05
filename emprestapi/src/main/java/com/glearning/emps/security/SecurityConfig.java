package com.glearning.emps.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Configure your authentication manager here, for example, in-memory user
		// details or a custom userDetailsService.
		auth.userDetailsService(userDetailsService);
		auth.inMemoryAuthentication().withUser("admin").password("{noop}password") // "{noop}" indicates that the
																					// password is not encoded (for
																					// testing purposes only)
				.roles("ADMIN");
	}
	// In Browser Server port 8081 credentials for Admin role
	// user id:admin
	// password:-password

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/api/employees").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/roles").permitAll() // Allow POST requests to /api/roles without
																		// authentication
				.antMatchers(HttpMethod.POST, "/api/users").permitAll() // Allow POST requests to /api/roles without
																		// authentication

				.anyRequest().authenticated().and().httpBasic();
	}
}
