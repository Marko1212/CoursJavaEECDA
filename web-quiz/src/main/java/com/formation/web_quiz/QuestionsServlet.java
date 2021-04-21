package com.formation.web_quiz;

import com.formation.web_quiz.entities.ChoiceEntity;
import com.formation.web_quiz.entities.QuizEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet("/questions")
public class QuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<QuizEntity> quizz = null;
	static int currentPositionListQuiz = 0;
	private static HashMap<Integer, Boolean> results = new HashMap<>();
	private Session session = null;

	@Override
	public void init() throws ServletException {
		super.init();
		session = HibernateUtils.getSession();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nbQuestions = request.getParameter("number_questions");
		// mise en session de number_questions pour le récupérer dans la jsp
		request.getSession().setAttribute("number_questions", nbQuestions);
		// TODO : Optimiser pour un changement du nombre de questions!!!
		if (quizz == null) {
			findAll(nbQuestions);
		}

		request.setAttribute("quiz", quizz.get(currentPositionListQuiz));

		request.setAttribute("title", "Questions");
		request.setAttribute("page", "questions");

		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	private void findAll(String nbQuestions) {
		Query<QuizEntity> q = session
				.createQuery("from QuizEntity", QuizEntity.class);
		q.setFirstResult(0);
		q.setMaxResults(Integer.parseInt(nbQuestions));

		quizz = null;
		quizz = q.list();
		Collections.shuffle(quizz);
		quizz.forEach(quiz -> Collections.shuffle(quiz.getChoices()));
		System.out.println(quizz.size());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String r = request.getParameter("response");
		if (r == null) {
			doGet(request, response);
			return;
		}

		Integer resp = Integer.parseInt(r);
//		Integer quizId = Integer.parseInt(request.getParameter("quiz_id"));

		boolean isOk = false;

		QuizEntity quiz = quizz.get(currentPositionListQuiz++);

		for (ChoiceEntity choice : quiz.getChoices()) {
			// le user a bien trouvé la bonne réponse
			if (choice.getId().equals(resp)) {
				if (quiz.getReponseCorrecte().equals(choice.getName())) {
					System.out.println("ok réponse correcte");
					isOk = true;
				}
			}
			// rechercher l'id de la bonne réponse pour l'envoyer à notre vue.
			if (quiz.getReponseCorrecte().equals(choice.getName())) {
				request.setAttribute("good_id", choice.getId());
				break;
			}
		}

		results.putIfAbsent(quiz.getId(), isOk);
		System.out.println(results);
		System.out.println(quizz.size());

		if (quizz.size() == currentPositionListQuiz){
			request
					.getSession()
					.setAttribute(
							"result",
							results.values()
									.stream()
									.filter(respOk -> respOk)
									.count()
							);
			request.getSession().setAttribute("nbQuestion", quizz.size()*1f);
//			int count = 0;
//			for (Boolean respOk:results.values()) {
//				if (respOk){
//					count++;
//				}
//			}
//			request.getSession().setAttribute("result", count);
		}

		request.setAttribute("end", quizz.size() == currentPositionListQuiz);
		request.setAttribute("answer", resp);
		request.setAttribute("quiz", quiz);
		request.setAttribute("title", "Questions");
		request.setAttribute("page", "questions");

		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	@Override
	public void destroy() {
		session.close();
		super.destroy();
	}

}
