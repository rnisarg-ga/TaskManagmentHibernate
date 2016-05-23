package com.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ModelSelectAll {
	private Configuration configuration = new Configuration().configure();
	private SessionFactory factory = configuration.buildSessionFactory();
	private boolean flag = false;

	public boolean CheckUserPassword(com.bean.Login login) {
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			String sql = "select count(L.login_id) from Login L where L.login_id=:login and L.password=:password";
			Query query = session.createQuery(sql);
			query.setParameter("login", login.getLogin_id());
			query.setParameter("password", login.getPassword());
			List list = query.list();
			Number number = (Number) list.get(0);
			if (number.intValue() > 0) {
				flag = true;

			} else {
				flag = false;

			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public boolean AdminLoginController(com.bean.Login login) {
		System.out.println("Inside AdminLoginController");
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			String sql = "Select count(login.email_id) from login "
					+ "JOIN user_role on user_role.user_role_id= login.user_role_id "
					+ "where user_role.user_role='admin' and login.email_id=:login and login.password=:password  ";
			System.out.println("Inside TRY");
			Query query = session.createSQLQuery(sql);
			query.setParameter("login", login.getLogin_id());
			query.setParameter("password", login.getPassword());
			List list = query.list();
			Number number = (Number) list.get(0);
			System.out.println(list.toString() + number.intValue());
			if (number.intValue() > 0) {
				flag = true;

			} else {
				flag = false;
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public boolean UserLoginController(com.bean.Login login) {
		try {
			Session session = factory.openSession();
			String sql = "Select count(login.email_id) from login "
					+ "JOIN user_role on user_role.user_role_id= login.user_role_id "
					+ "where user_role.user_role='User' and login.email_id=:login and login.password=:password  ";
			Query query = session.createSQLQuery(sql);
			query.setParameter("login", login.getLogin_id());
			query.setParameter("password", login.getPassword());
			List list = query.list();
			Number number = (Number) list.get(0);
			if (number.intValue() > 0) {
				flag = true;

			} else {
				flag = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

}
