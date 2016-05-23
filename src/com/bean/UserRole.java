package com.bean;

import java.io.Serializable;
import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user_role")
public class UserRole  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="user_role_id")
	private long userroleid;
	
	@Column(name="user_role")
	private String userrole;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<com.bean.Login> logins;
	
	public UserRole(){}
	
	public UserRole(long userroleid) {
		
		this.userroleid = userroleid;
	}

	
	public Collection<com.bean.Login> getLogins() {
		return logins;
	}

	public void setLogins(Collection<com.bean.Login> logins) {
		this.logins = logins;
	}

	public long getUserroleid() {
		return userroleid;
	}

	public void setUserroleid(long userroleid) {
		this.userroleid = userroleid;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	
	
	

}
