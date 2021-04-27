package com.formation.webbooks.servlets;

import com.formation.webbooks.PermissionEnum;
import com.formation.webbooks.entities.UserEntity;
import com.formation.webbooks.utils.HibernateUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static Validator validator;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();

		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(request.getParameter("email"));
		userEntity.setPassword(request.getParameter("password"));
		userEntity.setRePassword(request.getParameter("repassword"));
		userEntity.setFullname(request.getParameter("fullname"));
		userEntity.setPermission(PermissionEnum.USER);

		System.out.println(request.getHeader("referer"));

		Map<String, String> errors = new HashMap<>();
		if (userEntity.isSamePassword()){
			var check = this.verifyUser(userEntity);
			if (check.size() > 0){
				for (ConstraintViolation<UserEntity> c:check) {
					errors.put(c.getPropertyPath().toString(), c.getMessage());
				}
				request.getSession().setAttribute("signup-errors", errors);
				userEntity.setPassword("");
				userEntity.setRePassword("");
				request.getSession().setAttribute("signup-user", userEntity);
				response.sendRedirect(request.getHeader("referer") + "#open-modal-signup");
				return;
			}else{
				userEntity.generatePassword();

				Transaction tr = HibernateUtil.session.beginTransaction();
				HibernateUtil.session.save(userEntity);
				tr.commit();

				request.getSession().setAttribute("user", userEntity);
				response.sendRedirect(request.getHeader("referer"));
			}



		}else{
			System.out.println("password false");
			response.sendRedirect(request.getHeader("referer") + "#open-modal-signup");
			return;
		}

	}

	private Set<ConstraintViolation<UserEntity>> verifyUser(UserEntity user){
		return validator.validate(user);
	}
}
