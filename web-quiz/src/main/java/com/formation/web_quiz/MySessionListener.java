  
package com.formation.web_quiz;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener {

    private int sessionCounter = 0;

    public void sessionCreated(HttpSessionEvent se)  {
        synchronized (this) {
            sessionCounter++;
        }
        System.out.printf("Session créée - %d session en mémoire%n", sessionCounter);
    }

    public void sessionDestroyed(HttpSessionEvent se)  {
        synchronized (this) {
            sessionCounter--;
        }
        System.out.printf("Session détruite - %d session en mémoire%n", sessionCounter);
    }
	
}
