package com.egiftcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Specifies class is an entity and is mapped to a database table.
@Entity
//Specifies the name of the database table to be used for mapping
@Table(name = "gift_card")
public class GiftCard {
	
	@Id		//Specifies the primary key of an entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gift_card_id")
	private int giftCardId;
	
//	@Column(name = "gift_card_name")
//	private String giftCardName;
	
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "brand_id")
	private Brands brand;

	
	
	public int getGiftCardId() {
		return giftCardId;
	}

	public void setGiftCardId(int giftCardId) {
		this.giftCardId = giftCardId;
	}

//	public String getGiftCardName() {
//		return giftCardName;
//	}
//
//	public void setGiftCardName(String giftCardName) {
//		this.giftCardName = giftCardName;
//	}

	public Brands getBrand() {
		return brand;
	}

	public void setBrand(Brands brand) {
		this.brand = brand;
	}

	public GiftCard(int giftCardId, String giftCardName, Brands brand) {
		super();
		this.giftCardId = giftCardId;
//		this.giftCardName = giftCardName;
		this.brand = brand;
	}

	public GiftCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
//	@Column(name = "redemption_details")
//	private String redemptionDetails;
//	@Column(name = "minimum_amount")
//	private float minAmount=100;
//	@Column(name = "maximum_amount")
//	private float maxAmount=1000;
	
//	@Column(name="amount")
//	private float amount;
	
//	@Column(name = "gift_card_msg")
//	private String giftCardCustomizeMsg;


	
}
