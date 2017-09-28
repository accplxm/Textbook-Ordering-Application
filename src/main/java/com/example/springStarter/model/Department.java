package com.example.springStarter.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="department")
public class Department  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int department_id;
	private String departmentname;
	private String department;

	@OneToMany(targetEntity = User.class, mappedBy = "department",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<User> users;

	public void setUsers(Set<User> users) {
		this.users = users;
	}


	public int getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}


	public Set<User> getUsers() {
		return users;
	}

	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Department(String departmentname, String department) {

		this.departmentname = departmentname;
		this.department = department;
	}
	@Override
	public String toString() {
		return "department [departmentname=" + departmentname + ", department="
				+ department + "]";
	}
	public Department() {

	}





}
