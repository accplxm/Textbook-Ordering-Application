package com.example.springStarter.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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



@Entity(name="order_table")
public class Order implements Serializable  {

	  private static final long serialVersionUID = 1L;
	  public  enum status{dean,chair,done,faculty,notApproved,provost};
	  @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int order_id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date chairapproveddate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date deanapproveddate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date vicepresidentapproveddate;

	private boolean isrejected;
	private String rejectioncomments;

	public boolean isIsrejected() {
		return isrejected;
	}

	public void setIsrejected(boolean isrejected) {
		this.isrejected = isrejected;
	}

	public String getRejectioncomments() {
		return rejectioncomments;
	}

	public void setRejectioncomments(String rejectioncomments) {
		this.rejectioncomments = rejectioncomments;
	}

	public Date getChairapproveddate() {
		return chairapproveddate;
	}

	public void setChairapproveddate(Date chairapproveddate) {
		this.chairapproveddate = chairapproveddate;
	}

	public Date getDeanapproveddate() {
		return deanapproveddate;
	}

	public void setDeanapproveddate(Date deanapproveddate) {
		this.deanapproveddate = deanapproveddate;
	}

	public Date getVicepresidentapproveddate() {
		return vicepresidentapproveddate;
	}

	public void setVicepresidentapproveddate(Date vicepresidentapproveddate) {
		this.vicepresidentapproveddate = vicepresidentapproveddate;
	}

	@ManyToOne
	@JoinColumn(name = "term_id")
	private Term term;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private String status ;
	private String comments;
	private Boolean istextusedlater;

	@OneToMany(targetEntity = ClassOrder.class, mappedBy = "order",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<ClassOrder> classOrders;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}



	public Boolean getIstextusedlater() {
		return istextusedlater;
	}

	public void setIstextusedlater(Boolean istextusedlater) {
		this.istextusedlater = istextusedlater;
	}

	public Order() {
		super();
	}

	public List<ClassOrder> getClassOrders() {
		return classOrders;
	}

	public void setClassOrders(List<ClassOrder> classOrders) {
		this.classOrders = classOrders;
	}






}
