package com.formation.webbooks.servlets;

import com.formation.webbooks.entities.UserEntity;
import com.formation.webbooks.utils.HibernateUtil;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (!email.isEmpty() && !password.isEmpty()){
			Query<UserEntity> q = HibernateUtil.session.createQuery("from UserEntity where email = :email", UserEntity.class);
			q.setParameter("email", email);
			Optional<UserEntity> u = q.uniqueResultOptional();

			if (u.isEmpty()){
				response.sendRedirect(request.getHeader("referer"));
			}else{
				UserEntity jusTest = new UserEntity();
				jusTest.setPassword(password);
				jusTest.setSalt(u.get().getSalt());
				jusTest.generatePassword();

				if (u.get().getPassword().equals(jusTest.getPassword())){
					request.getSession().setAttribute("user", u.get());
					response.sendRedirect(request.getHeader("referer"));
				}
			}
		}

	}
}
