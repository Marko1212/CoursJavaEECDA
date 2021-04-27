package com.formation.webbooks.servlets;

import com.formation.webbooks.models.ContactModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
	private ContactModel contactModel = new ContactModel();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("title", "contact");
		request.setAttribute("page", "contact");
		request.setAttribute("header_active", "Contact");
		request.setAttribute("contact", contactModel);

		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contactModel = new ContactModel();
		contactModel.setFullname(request.getParameter("fullname"));
		contactModel.setEmail(request.getParameter("email"));
		contactModel.setMessage(request.getParameter("message"));

		request.setAttribute("errors", contactModel.checkErrors());
		System.out.println(contactModel);
		// TODO : send mail
		doGet(request, response);
	}
}
