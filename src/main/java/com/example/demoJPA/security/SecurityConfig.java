package com.example.demoJPA.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import com.example.demoJPA.auth.JWTFilter.JWTAuthenticationFilter;
import com.example.demoJPA.auth.JWTFilter.JWTAuthorizationFilter;
import com.example.demoJPA.auth.serviceJWT.JWTService;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired

	private JWTService jwtService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/api/login**").permitAll().antMatchers("/coches")
				.hasAnyRole("ADMIN", "USER").antMatchers("/").permitAll().and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtService))
				.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtService)).csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder())
				.withUser("ram").password(("ram123")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("ravan").password("ravan123").roles("USER");
		auth.inMemoryAuthentication().withUser("kans").password("kans123").roles("USER");
	}

}
