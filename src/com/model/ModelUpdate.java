package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ModelUpdate {

	private Configuration configuration = new Configuration().configure();
	private SessionFactory factory = configuration.buildSessionFactory();
	private boolean flag= false;
	
	public boolean UpdateTask(com.bean.TaskManagement  management){
		
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			session.update(management);
			session.getTransaction().commit();
			session.close();
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
}
