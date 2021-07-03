package com.formation.springwebflix.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final String userQuery = "select email, password, enabled from user where email = ?";
	
	private final DataSource datasource;

	@Autowired
	public SecurityConfiguration(DataSource datasource) {
		this.datasource = datasource;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery(userQuery);
		}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/*")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		String[] tab = {
				"/resources/**",
				"/static/**",
				"/css/**",
				"/js/**",
				"/uploads/**"
	};
	web.ignoring().antMatchers(tab);
	}
	
	
}

