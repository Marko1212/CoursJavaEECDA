package com.formation.webbooks.servlets;

import com.formation.webbooks.entities.BookEntity;
import com.formation.webbooks.utils.HibernateUtil;
import com.google.gson.Gson;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	private Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String query  = request.getParameter("q");

		query = query.replace(" ", "%");

		Query<BookEntity> q =
				HibernateUtil
						.session
						.createQuery("from BookEntity as b join b.authors a where a like :query or b.title like :query", BookEntity.class);
		q.setParameter("query", "%"+query+"%");

		out.append(gson.toJson(q.list()));
		out.flush();
	}
}
