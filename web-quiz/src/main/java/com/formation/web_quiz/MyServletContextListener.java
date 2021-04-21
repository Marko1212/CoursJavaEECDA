package com.formation.web_quiz;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  {
	    System.out.println("L'application est maintenant coupée!");
    }

    public void contextInitialized(ServletContextEvent sce)  {
	    System.out.println("Démarrage de l'application effectué");
    }
	
}
