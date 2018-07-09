package com.mtc.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.mtc.app.entity.User;

public class HIbernateUtil {

	
	private final static SessionFactory SESSION_FACTORY;
	
	
//	static block -- when this class is loaded to memory static block executes
//	class is just loaded once in the application memory
//	we create only one session factory object
	static {
		
//		predefines class in hibernate framework -- used in order to load hibernate framework
		Configuration configuration = new Configuration();
		
		
//		looks for configure.cfg.xml --- if file name is different pass the name of the file as parameter to the method
		configuration.configure();
		
//		register the user class here -- register all entity classes here
		
		configuration.addAnnotatedClass(User.class);
		
//		starts essencial services to work with hibernate framework
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		
		SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
		
		
	}

// session factory is private - to use session factory in the application -- create a getter method 
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
	
	
}
