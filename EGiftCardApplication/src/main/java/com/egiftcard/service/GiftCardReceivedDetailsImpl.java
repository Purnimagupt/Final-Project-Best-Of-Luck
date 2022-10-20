//package com.egiftcard.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.egiftcard.entity.GiftReceivedDetails;
//import com.egiftcard.repository.GiftCardReceivedDetailsRepository;
//
//@Service
//public class GiftCardReceivedDetailsImpl implements IGiftCardReceivedDetailsService{
//	
//	@Autowired
//	private GiftCardReceivedDetailsRepository giftCardReceivedRepo;
//	
//	@Override
//	public List<GiftReceivedDetails> getAllGiftReceivedDetails() {
//		return giftCardReceivedRepo.findAll();
//	}
//
//	@Override
//	public GiftReceivedDetails getGiftReceivedDetailsById(int giftReceivedId) {
//		Optional<GiftReceivedDetails> giftReceivedDetails=giftCardReceivedRepo.findById(giftReceivedId);
//		if(giftReceivedDetails.isPresent()) {
//			return giftReceivedDetails.get();
//		}
//		else {
//			return null;
//		}	
//	}
//	
//	
//	@Override
//	public GiftReceivedDetails addGiftReceivedDetails(GiftReceivedDetails giftReceivedDetails) {
//		return giftCardReceivedRepo.save(giftReceivedDetails);	
//	}
//	
//}
