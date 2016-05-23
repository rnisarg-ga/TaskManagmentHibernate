package com.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="alloted_task")
public class AllotedTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="alloted_task_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long allotedtaskid;
	
	
	@ManyToOne
	@JoinColumn(name="task_id",referencedColumnName ="task_id")
	private TaskManagement management;
	
	
	@ManyToOne
	@JoinColumn(name="email_id",referencedColumnName="email_id")
	private Login login;


	
	
	public AllotedTask() {
		
	}


	public AllotedTask(long allotedtaskid) {
	
		this.allotedtaskid = allotedtaskid;
	}


	public long getAllotedtaskid() {
		return allotedtaskid;
	}


	public void setAllotedtaskid(long allotedtaskid) {
		this.allotedtaskid = allotedtaskid;
	}


	public TaskManagement getManagement() {
		return management;
	}


	public void setManagement(TaskManagement management) {
		this.management = management;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	
	
}
