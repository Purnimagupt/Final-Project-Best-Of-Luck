//package com.egiftcard.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.egiftcard.entity.GiftReceivedDetails;
//import com.egiftcard.entity.GiftRedeemDetails;
//import com.egiftcard.exception.InvalidReceiveIdException;
//import com.egiftcard.exception.NoReceivedDetailsFoundException;
//import com.egiftcard.exception.NoRedeemDetailsFoundException;
//import com.egiftcard.repository.NotificationServiceReceivedRepository;
//import com.egiftcard.repository.NotificationServiceRedeemRepository;
//
//@Service
//public class NotificationServiceImpl implements INotificationService {
//	@Autowired
//	private NotificationServiceReceivedRepository GiftReceivedRepo;
//
//	@Override
//	public List<GiftReceivedDetails> getAllGiftReceivedDetails() throws NoReceivedDetailsFoundException {
//		if (GiftReceivedRepo.findAll().isEmpty()) {
//			throw new NoReceivedDetailsFoundException("No Details Found");
//		}
//		return GiftReceivedRepo.findAll();
//	}
//
//	@Autowired
//	private NotificationServiceRedeemRepository GiftRedeemRepo;
//
//	@Override
//	public List<GiftRedeemDetails> getAllGiftRedeemDetails() throws NoRedeemDetailsFoundException {
//		if (GiftRedeemRepo.findAll().isEmpty()) {
//			throw new NoRedeemDetailsFoundException("No Details found");
//		}
//		return GiftRedeemRepo.findAll();
//	}
//
//	@Override
//	public GiftRedeemDetails sendGiftRedeemDetailsNotification(int giftRedeemId) throws InvalidReceiveIdException {
//		if (!GiftRedeemRepo.findById(giftRedeemId).isPresent()) {
//			throw new InvalidReceiveIdException("Id is wrong");
//		}
//		Optional<GiftRedeemDetails> Op = GiftRedeemRepo.findById(giftRedeemId);
//		return Op.get();
//	}
//
//	public GiftReceivedDetails sendGiftReceivedDetailsNotification(int giftReceivedId) throws InvalidReceiveIdException {
//		if (!GiftReceivedRepo.findById(giftReceivedId).isPresent()) {
//			throw new InvalidReceiveIdException("Id is Wrong");
//		}
//		Optional<GiftReceivedDetails> Op = GiftReceivedRepo.findById(giftReceivedId);
//		{
//			return Op.get();
//
//		}
//
//	}
//}
