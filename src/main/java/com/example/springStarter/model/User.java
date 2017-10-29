package com.example.springStarter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity(name="user")
public class User implements Serializable  {

	  private static final long serialVersionUID = 1L;
	public  enum role{chair,faculty,dean,provost};
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	private String firstname;
	private String lastname;
	@Column(name = "email_id")
	private String emailid;
	private String role;
	private String initials;
	private Boolean isadmin;
	public Boolean getIsadmin() {
		return isadmin;
	}



	public void setIsadmin(Boolean isadmin) {
		this.isadmin = isadmin;
	}



	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;


public void setDepartment(Department department) {
		this.department = department;
	}



	public Department getDepartment() {
	     return department;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}

	public User( String firstname,String lastname, String emailid,
			String initials,String role) {
		super();
		this.setFirstname(firstname);
		this.lastname = lastname;
		this.emailid = emailid;
		this.initials = initials;
		this.setRole(role);
	}


	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public User(){

	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
