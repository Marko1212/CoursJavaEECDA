package com.formation.web_quiz;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/the-end")
public class ScoreServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String text = "";
		Object score = request.getSession().getAttribute("result");
		if (score != null){
			long s = (long)score;
			float percent = (s / (float)request.getSession().getAttribute("nbQuestion")) * 100;
			if (percent >= 99f){
				text = "Félicitations";
			}else if( percent >= 80f){
				text = "Pas mal";
			}else if (percent >= 50f){
				text = "Tout juste";
			}else{
				text = "Dommage";
			}
		}

		request.setAttribute("mention", text);
		request.setAttribute("title", "Score");
		request.setAttribute("page", "score");

		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
				.forward(request, response);
	}

}
