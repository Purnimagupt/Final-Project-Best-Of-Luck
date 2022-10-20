//package com.egiftcard.service;
//
//import java.util.List;
//
//import com.egiftcard.entity.GiftReceivedDetails;
//import com.egiftcard.entity.GiftRedeemDetails;
//import com.egiftcard.exception.InvalidReceiveIdException;
//import com.egiftcard.exception.NoReceivedDetailsFoundException;
//import com.egiftcard.exception.NoRedeemDetailsFoundException;
//
//public interface INotificationService {
//	List<GiftReceivedDetails> getAllGiftReceivedDetails() throws NoReceivedDetailsFoundException;
//	List<GiftRedeemDetails> getAllGiftRedeemDetails() throws  NoRedeemDetailsFoundException ;
//	
//	GiftRedeemDetails sendGiftRedeemDetailsNotification(int giftRedeemId)throws InvalidReceiveIdException ;
//	GiftReceivedDetails sendGiftReceivedDetailsNotification(int giftReceivedId)throws InvalidReceiveIdException;
//}
