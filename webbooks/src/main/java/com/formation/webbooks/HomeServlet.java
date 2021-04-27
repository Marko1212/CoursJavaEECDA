package com.formation.webbooks;

import com.formation.webbooks.entities.BookEntity;
import com.formation.webbooks.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



		Query<BookEntity> q = HibernateUtil.session.createQuery("from BookEntity where publishedDate <= :date order by publishedDate desc", BookEntity.class);
		q.setParameter("date", "2021");
		q.setFirstResult(0);
		q.setMaxResults(12);

		req.setAttribute("books", q.list());
		req.setAttribute("page", "home");
		req.setAttribute("title", "Home");
		req.setAttribute("header_active", "Home");

		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
	}
}
