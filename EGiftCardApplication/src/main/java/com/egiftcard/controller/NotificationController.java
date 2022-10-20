//package com.egiftcard.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.egiftcard.entity.GiftReceivedDetails;
//import com.egiftcard.entity.GiftRedeemDetails;
//import com.egiftcard.exception.InvalidReceiveIdException;
//import com.egiftcard.exception.NoReceivedDetailsFoundException;
//import com.egiftcard.exception.NoRedeemDetailsFoundException;
//import com.egiftcard.service.INotificationService;
//
//@RestController
//@RequestMapping("/notification")
//public class NotificationController {
//	
//	@Autowired
//	private INotificationService notificationService;
//
//	@GetMapping(value = "/received")
//	public List<GiftReceivedDetails> getAllGiftReceivedDetails() throws NoReceivedDetailsFoundException {
//		return notificationService.getAllGiftReceivedDetails();
//	}
//
//	@GetMapping(value ="/redeemed")
//	public List<GiftRedeemDetails> getAllGiftRedeemDetails() throws NoRedeemDetailsFoundException {
//		return notificationService.getAllGiftRedeemDetails();
//
//	}
//
//	@GetMapping("/redeem/{gift_redeem_id}")
//	public ResponseEntity<GiftRedeemDetails> sendGiftRedeemDetailsNotification(@PathVariable("gift_redeem_id") int giftRedeemId) throws InvalidReceiveIdException {
//		GiftRedeemDetails giftRedeemDet = notificationService.sendGiftRedeemDetailsNotification(giftRedeemId);
//		return new ResponseEntity<>(giftRedeemDet, HttpStatus.OK);
//	}
//
//	@GetMapping("/receive/{gift_received_id}")
//	public ResponseEntity<GiftReceivedDetails> sendGiftReceivedDetailsNotification(@PathVariable("gift_received_id") int giftReceivedId) throws InvalidReceiveIdException {
//		GiftReceivedDetails giftId = notificationService.sendGiftReceivedDetailsNotification(giftReceivedId);
//		return new ResponseEntity<>(giftId, HttpStatus.OK);
//	}
//
//}
