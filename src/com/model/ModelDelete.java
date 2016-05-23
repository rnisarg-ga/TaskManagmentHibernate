package com.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.WorkLog;

public class ModelDelete {
	private Configuration configuration = new Configuration().configure();
	private SessionFactory factory = configuration.buildSessionFactory();
	private boolean flag = false;

	public void DeleteTask(long taskid) {
		System.out.println("Task ID was :-" + taskid);
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			String sql = "Delete from AllotedTask w where w.management.taskid=:taskid";
			Query query = session.createQuery(sql);
			query.setParameter("taskid", taskid);
			query.executeUpdate();  
			
			String sql1="Delete from TaskManagement t where t.taskid=:t1";
			Query query2 = session.createQuery(sql1);
			query2.setParameter("t1", taskid);
			query2.executeUpdate();
			
			session.getTransaction().commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
