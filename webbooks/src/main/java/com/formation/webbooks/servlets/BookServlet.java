package com.formation.webbooks.servlets;

import com.formation.webbooks.entities.BookEntity;
import com.formation.webbooks.utils.HibernateUtil;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null || id.isEmpty()){
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		Query<BookEntity> q = HibernateUtil.session.createQuery("from BookEntity where id = :id", BookEntity.class);
		q.setParameter("id", id);
		Optional<BookEntity> book = q.uniqueResultOptional();

		if (book.isEmpty()){
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}

		request.setAttribute("book", book.get());
		request.setAttribute("title", book.get().getTitle());
		request.setAttribute("page", "book");

		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
}
