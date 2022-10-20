//package com.egiftcard.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.egiftcard.entity.GiftReceivedDetails;
//import com.egiftcard.service.IGiftCardReceivedDetailsService;
//
//@RestController
//@RequestMapping("/giftreceived")
//public class GiftCardReceivedDetailsController {
//	@Autowired
//	private IGiftCardReceivedDetailsService giftCardReceivedService;
//	
//	@GetMapping
//	public List<GiftReceivedDetails> getAllGiftReceivedDetails(){
//		return giftCardReceivedService.getAllGiftReceivedDetails();
//	}
//	
//	@GetMapping("{gift_received_id}")
//	public ResponseEntity<GiftReceivedDetails> getGiftCardReceivedById(@PathVariable("gift_received_id") int giftReceivedId){
//		return new ResponseEntity<>(giftCardReceivedService.getGiftReceivedDetailsById(giftReceivedId),HttpStatus.OK);
//	}
//	
//	@PostMapping
//	public ResponseEntity<GiftReceivedDetails> addGiftReceivedDetails(@RequestBody GiftReceivedDetails giftReceivedDetails){
//		return new ResponseEntity<>(giftCardReceivedService.addGiftReceivedDetails(giftReceivedDetails), HttpStatus.CREATED);
//	}
//}
