package com.controller;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory=null;
	static
	{
		try
		{
			Configuration configuration= new Configuration().configure();
			configuration.addAnnotatedClass(com.classesAndStudent.Classes.class);
			configuration.addAnnotatedClass(com.classesAndStudent.Student.class);
			configuration.addAnnotatedClass(com.subjects.Subject.class);
			configuration.addAnnotatedClass(com.teachers.Teacher.class);

			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			factory=configuration.buildSessionFactory(builder.build());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public static SessionFactory getSessionFactory()
	{
		return factory;
	}

}
