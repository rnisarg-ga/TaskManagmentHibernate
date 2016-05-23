package com.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="login")
@NamedQueries({@NamedQuery(name="Login.SelectAll",query="from Login")})
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="email_id")
	private String login_id;
	
	@Column(name="password")
	private String password;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name="user_role_id",referencedColumnName="user_role_id")
	private UserRole role;

	@OneToMany(cascade = CascadeType.ALL)
	private Collection<com.bean.TaskManagement> collection;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<com.bean.AllotedTask> allotedTasks;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<com.bean.WorkLog> workLogs;
	
	
	
	public Collection<com.bean.AllotedTask> getAllotedTasks() {
		return allotedTasks;
	}



	public void setAllotedTasks(Collection<com.bean.AllotedTask> allotedTasks) {
		this.allotedTasks = allotedTasks;
	}



	public Collection<com.bean.TaskManagement> getCollection() {
		return collection;
	}



	public void setCollection(Collection<com.bean.TaskManagement> collection) {
		this.collection = collection;
	}



	public Login() {
		
	}



	public Login(String login_id) {
		
		this.login_id = login_id;
	}



	public String getLogin_id() {
		return login_id;
	}



	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public UserRole getRole() {
		return role;
	}



	public void setRole(UserRole role) {
		this.role = role;
	}
	
	
	
	
	
	
	
}
