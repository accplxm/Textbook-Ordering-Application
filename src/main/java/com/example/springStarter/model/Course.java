package com.example.springStarter.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="class")
public class Course implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int class_id;
		private String classname;
		@Column(name = "class")
		private String courseId;
		@ManyToOne
		@JoinColumn(name = "department_id")
		private Department department;

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		@OneToMany(targetEntity = ClassOrder.class, mappedBy = "course",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
		private Set<ClassOrder> classOrders;

		public int getClass_id() {
			return class_id;
		}

		public void setClass_id(int class_id) {
			this.class_id = class_id;
		}

		public String getClassname() {
			return classname;
		}

		public void setClassname(String classname) {
			this.classname = classname;
		}

		public String getCourseId() {
			return courseId;
		}

		public void setCourseId(String courseId) {
			this.courseId = courseId;
		}

		public Set<ClassOrder> getClassOrders() {
			return classOrders;
		}

		public void setClassOrders(Set<ClassOrder> classOrders) {
			this.classOrders = classOrders;
		}

		public Course() {
			super();
		}

}
