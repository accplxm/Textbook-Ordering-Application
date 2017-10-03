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


@Entity(name="term")
public class Term  implements Serializable{

	private static final long serialVersionUID = 1L;
	public enum semester{Fall,Winter,Spring,Summer,Session};
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int term_id;
	private int year;
	private String semester;

	@OneToMany(targetEntity = Order.class, mappedBy = "term",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Order> orders;

	public int getTerm_id() {
		return term_id;
	}

	public void setTerm_id(int term_id) {
		this.term_id = term_id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Term() {
		super();
	}






}
