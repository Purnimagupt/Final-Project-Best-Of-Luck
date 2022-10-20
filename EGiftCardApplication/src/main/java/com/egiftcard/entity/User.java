package com.egiftcard.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	
	@Id
	private String userName;
	
	@NotBlank(message="Name can not be blank")
	@Column(name = "name")
	private String name;
	@Email(message="Please,Enter valid email")
	private String email;
	@Pattern(regexp="^\\d{10}", message="Mobile number should have 10 digits only")
	private String mobile;
	@Size(min=8, message="Minimum password length should be 8 characters")
	private String password;
//	private String address;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="User_Role", 
	joinColumns = {@JoinColumn(name="USER_ID")},
	inverseJoinColumns = {@JoinColumn(name="ROLE_ID")}
	)
	private Set<Role> role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public User(String userName, @NotBlank(message = "Name can not be blank") String name,
			@Email(message = "Please,Enter valid email") String email,
			@Pattern(regexp = "^\\d{10}", message = "Mobile number should have 10 digits only") String mobile,
			@Size(min = 8, message = "Minimum password length should be 8 characters") String password,
			Set<Role> role) {
		super();
		this.userName = userName;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
	
	
	
}


