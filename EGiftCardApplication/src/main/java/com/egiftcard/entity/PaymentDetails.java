package com.egiftcard.entity;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "payment_details")
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int paymentID;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "payment_date")
	private Date paymentDate;

	@Column(name = "name_on_card")
	@NotBlank(message = "Name must not be blank")
	@Pattern(regexp = "^([A-z\\'\\.-]*+(\\s))+[A-z\\'\\.-]*$", message = "Please enter a valid name")
	private String nameOnCard;
	
	@Column(name = "payment_amount")
	private float paymentAmount;

	@Column(name="full_name")
	private String fullName;
	
	@Column(name = "card_number")
	@Pattern(regexp = "^\\d{14,16}$", message = "Enter valid card number")
	private String cardNumber;
	
	@JsonFormat(pattern = "MM-yy")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "card_expiry")
	private Date cardExpiry;
	
	@Pattern(regexp = "^\\d{3}$", message = "cvv must be a 3 digit number")
	private String cvv;

	@ManyToOne // (cascade = CascadeType.ALL)
	@JoinColumn(name = "user_gift_id")
	private UserGiftDetails userGiftDetails;

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(Date cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public UserGiftDetails getUserGiftDetails() {
		return userGiftDetails;
	}

	public void setUserGiftDetails(UserGiftDetails userGiftDetails) {
		this.userGiftDetails = userGiftDetails;
	}

	public PaymentDetails(int paymentID, Date paymentDate,
			@NotBlank(message = "Name must not be blank") @Pattern(regexp = "^([A-z\\'\\.-]*+(\\s))+[A-z\\'\\.-]*$", message = "Please enter a valid name") String nameOnCard,
			float paymentAmount, String fullName,
			@Pattern(regexp = "^\\d{14,16}$", message = "Enter valid card number") String cardNumber, Date cardExpiry,
			@Pattern(regexp = "^\\d{3}$", message = "cvv must be a 3 digit number") String cvv,
			UserGiftDetails userGiftDetails) {
		super();
		this.paymentID = paymentID;
		this.paymentDate = paymentDate;
		this.nameOnCard = nameOnCard;
		this.paymentAmount = paymentAmount;
		this.fullName = fullName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
		this.userGiftDetails = userGiftDetails;
	}

	
	public PaymentDetails() {
		super();
	}

	
	
}
