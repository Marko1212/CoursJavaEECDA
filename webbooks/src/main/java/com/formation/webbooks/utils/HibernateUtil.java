package com.formation.webbooks.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static Session session = getSession();

	private static SessionFactory buildSessionFactory(){
		return new Configuration().configure().buildSessionFactory();
	}

	public static Session getSession() throws HibernateException {
		return buildSessionFactory().openSession();
	}
}
