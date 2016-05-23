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
@Table(name="worklog")
public class WorkLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long worklogid;

	@Column(name="starting_time")
	private String Starting_time;
	
	@Column(name="spend_time")
	private String spend_time;
	
	
	@ManyToOne
	@JoinColumn(name="task_id",referencedColumnName="task_id")
	private com.bean.TaskManagement management;
	
	@ManyToOne
	@JoinColumn(name="email_id" ,referencedColumnName="email_id")
	private com.bean.Login login;


	public WorkLog() {
		
	}
	
	public WorkLog(long worklogid) {
		
		this.worklogid = worklogid;
	}



	public long getWorklogid() {
		return worklogid;
	}

	public void setWorklogid(long worklogid) {
		this.worklogid = worklogid;
	}

	public String getStarting_time() {
		return Starting_time;
	}

	public void setStarting_time(String starting_time) {
		Starting_time = starting_time;
	}

	public String getSpend_time() {
		return spend_time;
	}

	public void setSpend_time(String spend_time) {
		this.spend_time = spend_time;
	}

	public com.bean.TaskManagement getManagement() {
		return management;
	}

	public void setManagement(com.bean.TaskManagement management) {
		this.management = management;
	}

	public com.bean.Login getLogin() {
		return login;
	}

	public void setLogin(com.bean.Login login) {
		this.login = login;
	}
	
	
	
	
}
