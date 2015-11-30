package org.softala.roboapp.model;
// default package
// Generated Oct 26, 2015 8:47:24 AM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity mapped to the session table in the database
 */
@Entity
@Table(name = "order_contact")
public class OrderContact implements java.io.Serializable {

	/*
	 * New table was made handle closing dialogs Closing bean is no longer in
	 * use. Due to us being short time we chose to make new table to reduce the
	 * chance of unexpected problems. Closing saves unverified data into
	 * database and sends it forward into email. Only validation is form
	 * frontend that checks email format and hibernate that checks that values
	 * compliment SQL configurations.
	 * -Kortelainen TEAM 1
	 */
	private static final long serialVersionUID = -1442354512361067444L;
	private Integer orderId;
	private Session session;
	private String email;
	private Date created;

	public OrderContact() {
	}

	public OrderContact(Integer orderId) {
		this.orderId = orderId;
	}

	public OrderContact(String orderId, Session session, Date created, String email) {
		this.session = session;
		this.created = created;
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderid) {
		this.orderId = orderid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "session_id")
	@JsonBackReference
	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
