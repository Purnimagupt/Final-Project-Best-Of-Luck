package com.egiftcard.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

//Specifies class is an entity and is mapped to a database table.
@Entity

//Specifies the name of the database table to be used for mapping
@Table(name = "user_gift_details")

public class UserGiftDetails {
	
	@Id		//Specifies the primary key of an entity
	//@GeneratedValue: This annotation is used to specify the primary key generation strategy to use. i.e. 
	//Instructs database to generate a value for this field automatically. 
	//If the strategy is not specified by default AUTO will be used.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column annotation used for adding the name of the column in database
	@Column(name = "user_gift_id")
	private int userGiftId;
	@Column(name = "gift_card_amount")
	private float giftCardAmount;
	

	@NotBlank(message = "Name is mandatory")
	@Column(name = "recepient_name")
	private String recepientName;
	//@Range(min = 10, max = 10)
	@Column(name = "recepient_mobile")
	private long receipientMobile;
	
	@Column(name = "recepient_email")
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email is not valid")
	private String recepientEmail;

	
		
	@ManyToOne
	@JoinColumn(name = "userName")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "gift_card_id")
	private GiftCard giftCard;
	
	

	public int getUserGiftId() {
		return userGiftId;
	}

	public void setUserGiftId(int userGiftId) {
		this.userGiftId = userGiftId;
	}

	public float getGiftCardAmount() {
		return giftCardAmount;
	}

	public void setGiftCardAmount(float giftCardAmount) {
		this.giftCardAmount = giftCardAmount;
	}

	public String getRecepientName() {
		return recepientName;
	}

	public void setRecepientName(String recepientName) {
		this.recepientName = recepientName;
	}

	public long getReceipientMobile() {
		return receipientMobile;
	}

	public void setReceipientMobile(long receipientMobile) {
		this.receipientMobile = receipientMobile;
	}

	public String getRecepientEmail() {
		return recepientEmail;
	}

	public void setRecepientEmail(String recepientEmail) {
		this.recepientEmail = recepientEmail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public GiftCard getGiftCard() {
		return giftCard;
	}

	public void setGiftCard(GiftCard giftCard) {
		this.giftCard = giftCard;
	}

	public UserGiftDetails(int userGiftId, float giftCardAmount,
			@NotBlank(message = "Name is mandatory") String recepientName, long receipientMobile,
			@NotBlank(message = "Email is mandatory") @Email(message = "Email is not valid") String recepientEmail,
			User user, GiftCard giftCard) {
		super();
		this.userGiftId = userGiftId;
		this.giftCardAmount = giftCardAmount;
		this.recepientName = recepientName;
		this.receipientMobile = receipientMobile;
		this.recepientEmail = recepientEmail;
		this.user = user;
		this.giftCard = giftCard;
	}

	public UserGiftDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserGiftDetails [userGiftId=" + userGiftId + ", giftCardAmount=" + giftCardAmount + ", recepientName="
				+ recepientName + ", receipientMobile=" + receipientMobile + ", recepientEmail=" + recepientEmail
				+ ", user=" + user + ", giftCard=" + giftCard + "]";
	}
	
	
	
}