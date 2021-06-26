package com.formation.springwebflix.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Email
	@NotEmpty
	private String email;

	@Column(nullable=false)
	@NotNull
	@Size(min=6, max=64)
	private String password;
	
	@Transient
	@Size(min=6, max=64)
	private String repassword;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="requested_at")
	private Date requestedAt;

	private String token;

	@Column(nullable=false, unique = true)
	@Pattern(regexp = "^[a-z0-9À-ÖØ-öø-ÿ]{3,64}$", flags= {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.DOTALL})
	private String username;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="user")
	private List<Payment> payments;

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public Date getRequestedAt() {
		return this.requestedAt;
	}

	public void setRequestedAt(Date requestedAt) {
		this.requestedAt = requestedAt;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setUser(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setUser(null);

		return payment;
	}

}