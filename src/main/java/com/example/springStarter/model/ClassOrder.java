package com.example.springStarter.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="class_order")
public class ClassOrder implements Serializable {



	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int class_order_id;
	@ManyToOne
	@JoinColumn(name = "class_id")
	private Course course;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	@ManyToOne
	@JoinColumn(name = "textbook_id")
	private Textbook textbook;
	private String Comments;
	public int getClass_order_id() {
		return class_order_id;
	}
	public void setClass_order_id(int class_order_id) {
		this.class_order_id = class_order_id;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Textbook getTextbook() {
		return textbook;
	}
	public void setTextbook(Textbook textbook) {
		this.textbook = textbook;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public ClassOrder() {
		super();
	}


}
