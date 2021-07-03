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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final String userQuery = "select email, password, enabled from user where email = ?";
	
	private final String roleQuery = "select u.email, r.code from user u inner join role r on (u.role_id = r.id) where email = ?";
	
	
	
	private final DataSource datasource;

	@Autowired
	public SecurityConfiguration(DataSource datasource) {
		this.datasource = datasource;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery(userQuery)
		.authoritiesByUsernameQuery(roleQuery)
		.passwordEncoder(new BCryptPasswordEncoder());
		}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/")
		.permitAll()
		.antMatchers("/sign-up")
		.permitAll()
		.antMatchers("/sign-in")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.csrf()
		.disable()
		.formLogin()
		.loginPage("/sign-in")
		.defaultSuccessUrl("/", true)
		.failureUrl("/sign-in?error=true")
		.usernameParameter("email")
		.passwordParameter("password")
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/");
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
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

