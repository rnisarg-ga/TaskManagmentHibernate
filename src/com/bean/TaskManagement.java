package com.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="task_management")
public class TaskManagement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="task_id")
	private long taskid;
	
	@Column(name="task_name")
	private String task_name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="starting_date")
	private String starting_date;

	@Column(name="ending_date")
	private String ending_date;
	
	@ManyToOne(optional =false)
	@JoinColumn(name="email_id",referencedColumnName="email_id")
	private Login login;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<com.bean.AllotedTask> allotedTasks;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<com.bean.WorkLog> collection;
	
	
	public Collection<com.bean.WorkLog> getCollection() {
		return collection;
	}

	public void setCollection(Collection<com.bean.WorkLog> collection) {
		this.collection = collection;
	}

	public Collection<com.bean.AllotedTask> getAllotedTasks() {
		return allotedTasks;
	}

	public void setAllotedTasks(Collection<com.bean.AllotedTask> allotedTasks) {
		this.allotedTasks = allotedTasks;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public TaskManagement(){}

	public TaskManagement(long taskid) {
		this.taskid = taskid;
	}

	public long getTaskid() {
		return taskid;
	}

	public void setTaskid(long taskid) {
		this.taskid = taskid;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStarting_date() {
		return starting_date;
	}

	public void setStarting_date(String starting_date) {
		this.starting_date = starting_date;
	}

	public String getEnding_date() {
		return ending_date;
	}

	public void setEnding_date(String ending_date) {
		this.ending_date = ending_date;
	}
	
	
	
	
	
}
