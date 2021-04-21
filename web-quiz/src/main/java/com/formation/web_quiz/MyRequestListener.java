package com.formation.web_quiz;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyRequestListener implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent sre)  {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        request.setAttribute("startTime", System.currentTimeMillis());
    }

    public void requestDestroyed(ServletRequestEvent sre)  {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        long startTime = (long) request.getAttribute("startTime");
        System.out.printf("La requête a mis %d millisecondes%n", System.currentTimeMillis() - startTime);
    }
}