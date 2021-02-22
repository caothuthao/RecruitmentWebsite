package com.vti.mock.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final MyUserDetailsService userDetailsService;
	private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	private final CustomAuthenticationSuccessHandle customAuthenticationSuccessHandle;

	@Autowired
	public SecurityConfig(MyUserDetailsService userDetailsService,
			CustomAuthenticationFailureHandler customAuthenticationFailureHandler,
			CustomAuthenticationSuccessHandle customAuthenticationSuccessHandle) {
		this.userDetailsService = userDetailsService;
		this.customAuthenticationFailureHandler = customAuthenticationFailureHandler;
		this.customAuthenticationSuccessHandle = customAuthenticationSuccessHandle;
	}

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String login = "/login";
		String[] permitAll = { "/get_refresh_token", "/j_spring_security_login", login, "/j_spring_security_logout",
				"/change_language" };
		String[] anyRoles = { "/change_password" };
		String[] adminRole = { "/student/**" };
		http.authorizeRequests().antMatchers(permitAll).permitAll().antMatchers(anyRoles)
				.access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')").antMatchers(adminRole).access("hasRole('ROLE_ADMIN')")
				.anyRequest().authenticated().and().exceptionHandling().accessDeniedPage("/403");

		http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(3600);

		http.authorizeRequests().and().formLogin().loginProcessingUrl("/j_spring_security_login").loginPage(login)
				.successHandler(customAuthenticationSuccessHandle).failureHandler(customAuthenticationFailureHandler)
				.usernameParameter("username").passwordParameter("password").and().logout()
				.logoutUrl("/j_spring_security_logout").deleteCookies("JSESSIONID").invalidateHttpSession(true)
				.clearAuthentication(true).logoutSuccessUrl(login);
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/webfonts/**");
	}

}
