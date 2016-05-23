package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.AllotedTask;
import com.bean.Login;

public class ServiceModel {
	private Configuration configuration = new Configuration().configure();
	private SessionFactory factory = configuration.buildSessionFactory();
	private boolean flag= false;
	
	public boolean AddUserRole(com.bean.UserRole role){
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			session.save(role);
			session.getTransaction().commit();
			session.close();
			flag = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean AddUserDetails(com.bean.Login login){
		
		
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			session.save(login);
			
			session.getTransaction().commit();
			session.close();
			flag = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	public boolean AddUserTask(com.bean.TaskManagement management,com.bean.AllotedTask allotedTask){
	
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			session.persist(management);
			session.persist(allotedTask);
			
			//session.save(management);
			
			session.getTransaction().commit();
			session.close();
			flag = true;
			
			
		} catch (Exception e) {
			
		}
		return flag;
	}
	
	public boolean AddWorkLog(com.bean.WorkLog workLog){
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			session.save(workLog);
			session.getTransaction().commit();
			session.close();
			flag = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
