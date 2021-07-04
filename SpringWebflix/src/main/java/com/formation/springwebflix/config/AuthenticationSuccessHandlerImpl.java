package com.formation.springwebflix.config;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.formation.springwebflix.services.UserService;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	private final UserService userService;
	
	@Autowired
	public AuthenticationSuccessHandlerImpl(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String email = "";
		if (authentication.getPrincipal() instanceof Principal) {
			email = ((Principal)authentication.getPrincipal()).getName();
		} else {
			email = ((User)authentication.getPrincipal()).getUsername();
		}
		
		com.formation.springwebflix.entities.User user = userService.findByEmailOrUsername(email).orElse(null);
		
		request.getSession().setAttribute("userEmail", user.getEmail());
		request.getSession().setAttribute("userUsername", user.getUsername());
		response.sendRedirect(request.getContextPath() + "/");
	}
	
}
