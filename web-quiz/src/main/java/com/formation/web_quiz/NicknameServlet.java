package com.formation.web_quiz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NicknameServlet
 */
@WebServlet("/nickname")
public class NicknameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NicknameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("title", "Nickname");
		request.setAttribute("page", "nickname");
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		
		if (nickname.trim().length() < 4) {
			request.setAttribute("error", "Vérifie le champ texte. Il doit avoir au minimum 4 caractères");
			request.setAttribute("nickname", nickname);
			doGet(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("nickname", nickname);
		//session.setMaxInactiveInterval(15);
		System.out.println(session.getId());
		System.out.println(session.getCreationTime());
		System.out.println(session.getLastAccessedTime());

		Cookie cookie = new Cookie("nickname", nickname);
		cookie.setSecure(true);
		cookie.setMaxAge(30);
		response.addCookie(cookie);

		response.sendRedirect(request.getContextPath() + "/number-questions");
		
		}

		
	
	}
