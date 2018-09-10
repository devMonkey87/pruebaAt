package com.example.demoJPA.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

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

		http.authorizeRequests().antMatchers("/coches/**").hasAnyRole("ADMIN").antMatchers("/").permitAll().and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtService))
				.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtService)).csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

//		String idForEncode = "SHA-256";
//		Map<String, PasswordEncoder> encoders = new HashMap<>();
//		encoders.put(idForEncode, new MessageDigestPasswordEncoder("SHA-256"));
//		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
//		encoders.put("scrypt", new SCryptPasswordEncoder());
//
//		PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);
//
//		String pword = Jwts.builder().signWith(SignatureAlgorithm.HS512,
//				"pwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpwordpword"
//						.getBytes())
//				.compact();

		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("jose")
				.password("JOSE123").roles("ADMIN", "USER").and()
				// .passwordEncoder(passwordEncoder);
				.withUser("user").password("xxx").roles("USER");
		// .passwordEncoder(passwordEncoder);

	}

}
