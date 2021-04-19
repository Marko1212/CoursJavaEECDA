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

import com.formation.web_quiz.entities.ChoiceEntity;
import com.formation.web_quiz.entities.QuizEntity;

@WebServlet("/questions")
public class QuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Session session = null;
	private static List<QuizEntity> quizz = null;
	
	@Override
	public void init() throws ServletException {
		super.init();
		session = HibernateUtils.getSession();

	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nbQuestions = request.getParameter("number_questions");
		// TODO : Optimiser pour un changement du nombre de questions!!!
		if (quizz == null) {
			findAll(nbQuestions);			
		}
		
		String currentQuestion = request.getParameter("q");
		
		if (currentQuestion == null) {
			request.setAttribute("quiz", quizz.get(0));
		}else if (currentQuestion.equals("") || Integer.parseInt(currentQuestion) <= 1) {
			// TODO: Améliorer le code afin d'envoyer une erreur 404
			request.setAttribute("quiz", quizz.get(0));
		}else {
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
		Query<QuizEntity> q = session
				.createQuery("from QuizEntity", QuizEntity.class);
		q.setFirstResult(0);
		q.setMaxResults(Integer.parseInt(nbQuestions));
		
		quizz = q.list();
		System.out.println(quizz.size());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer resp = Integer.parseInt(request.getParameter("response"));
		Integer quizId = Integer.parseInt(request.getParameter("quiz_id"));
		
		for(QuizEntity quiz : quizz) {
			if (quiz.getId().equals(quizId)) {
				for(ChoiceEntity choice : quiz.getChoices()) {
					if (choice.getId().equals(resp)) {
						if (quiz.getReponseCorrecte().equals(choice.getName())) {
							System.out.println("ok réponse correcte");
						}
					}
				}
			}
		}
				
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		session.close();
		super.destroy();
	}

}
