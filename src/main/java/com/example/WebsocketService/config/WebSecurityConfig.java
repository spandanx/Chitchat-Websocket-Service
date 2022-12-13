package com.example.WebsocketService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//import io.undertow.server.handlers.RequestDumpingHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Value("${in-memory-auth.username}")
	private String USERNAME;
	
	@Value("${in-memory-auth.password}")
	private String PASSWORD;
	
	@Value("${in-memory-auth.role}")
	private String ROLE;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.headers().frameOptions().sameOrigin(); //for h2
		
		http
	        .csrf().disable()
	        .cors().disable()
			.authorizeRequests()
//			.antMatchers("/auth/generate").permitAll()
//			.antMatchers("/api/public").permitAll()
//			.antMatchers("/h2-console/**").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
//			.and().sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		return http.build();
	}
	
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username(USERNAME)
            .password(PASSWORD)
            .roles(ROLE)
            .build();
        return new InMemoryUserDetailsManager(user);
    }
	
//	@Bean
//    public UndertowServletWebServerFactory undertowServletWebServerFactory() {
//        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
//        factory.addDeploymentInfoCustomizers(deploymentInfo -> 
//               	deploymentInfo.addInitialHandlerChainWrapper(handler -> {
//        	return new RequestDumpingHandler(handler);
//        }));
//            
//        return factory;
//    }
}
