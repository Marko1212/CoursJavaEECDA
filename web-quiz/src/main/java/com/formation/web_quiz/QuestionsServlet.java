package com.formation.web_quiz;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.formation.web_quiz.entities.QuizEntity;


/**
 * Servlet implementation class QuestionsServlet
 */
@WebServlet("/questions")
public class QuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Session session = null;
	private static List<QuizEntity> quizz = null;
	
	@Override
	public void init() throws ServletException {
		super.init();
		session = HibernateUtils.getSession();
	}
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nbQuestions = request.getParameter("number_questions");
		//TODO : Je vais pouvoir faire une requête SQL pour
		// récupérer mon nombre de questions
		
		// Hibernate
		
		// TODO / Optimiser pour un changement du nombre de questions!!!
		if (quizz == null) {
		findAll(nbQuestions);
		}
		
		String currentQuestion = request.getParameter("q");
		
		if (currentQuestion == null) {
		request.setAttribute("quiz", quizz.get(0));
		} else if (currentQuestion.equals("")) {
			// TODO: Améliorer le code afin d'envoyer une erreur 404
						request.setAttribute("quiz", quizz.get(0));
					} else {
			Integer nb = Integer.parseInt(currentQuestion);
			
			if (nb > quizz.size()) {
				nb = quizz.size();
			}
			
			request.setAttribute("quiz", quizz.get(nb - 1));
		
		}
		
		request.setAttribute("end", quizz.size());
		request.setAttribute("title", "Questions");
		request.setAttribute("page", "questions");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	private void findAll(String nbQuestions) {
		Query<QuizEntity> q = session.createQuery("from QuizEntity", QuizEntity.class);
		
		q.setFirstResult(0);
		q.setMaxResults(Integer.parseInt(nbQuestions));
		
		
		quizz = q.list();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resp = request.getParameter("response");
		System.out.println(resp);
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		session.close();
		super.destroy();
	}
	

}
