package com.example.springStarter.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity(name="order")
public class Order implements Serializable  {

	  private static final long serialVersionUID = 1L;
	  public  enum status{dean,chair,done};
	  @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int order_id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;
	@ManyToOne
	@JoinColumn(name = "term_id")
	private Term term;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private status status;
	private String comments;
	private String istextusedlater;

	@OneToMany(targetEntity = ClassOrder.class, mappedBy = "order",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<ClassOrder> classOrders;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}



	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public status getStatus() {
		return status;
	}

	public void setStatus(status status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getIstextusedlater() {
		return istextusedlater;
	}

	public void setIstextusedlater(String istextusedlater) {
		this.istextusedlater = istextusedlater;
	}

	public Set<ClassOrder> getClassOrders() {
		return classOrders;
	}

	public Order() {
		super();
	}

	public void setClassOrders(Set<ClassOrder> classOrders) {
		this.classOrders = classOrders;
	}





}
