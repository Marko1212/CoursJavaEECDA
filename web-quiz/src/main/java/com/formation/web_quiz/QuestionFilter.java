  
package com.formation.web_quiz;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
		urlPatterns = {"/number-questions/*",
				"/questions/*",
				"/the-end/*"}
)
public class QuestionFilter implements Filter {
	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		System.out.println("Je suis dans mon filtre!!!");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		Object nickname = req.getSession().getAttribute("nickname");

		if (nickname != null) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(req.getContextPath() + "/nickname");
		}

	}
	
}
