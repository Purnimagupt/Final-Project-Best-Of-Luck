package com.egiftcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiftcard.entity.GiftCard;
import com.egiftcard.exception.DuplicateGiftCardIdException;
import com.egiftcard.exception.GiftCardNotFoundException;
import com.egiftcard.exception.InvalidIdException;
import com.egiftcard.repository.GiftCardManagementRepository;

@Service
public class GiftCardManagementServiceImpl implements IGiftCardManagementService{
	
	@Autowired
	private GiftCardManagementRepository giftCardRepository;
	
	@Override
	public List<GiftCard> getAllGiftCards() {
		return giftCardRepository.findAll();
		}

	
	@Override
	public GiftCard getGiftCardById(Integer giftCardId)throws GiftCardNotFoundException,InvalidIdException {
		Optional<GiftCard> giftCardObj=giftCardRepository.findById(giftCardId);
		if(!giftCardObj.isPresent()) {
			throw new GiftCardNotFoundException("GiftCard with this Id " +giftCardId +"  does not exist!");
		}
		if(giftCardId==0 || giftCardId<0) {
			throw new InvalidIdException("Invalid Id! Enter correct Id!");
		}
		return giftCardObj.get();
	}

	@Override
	public GiftCard registerGiftCard(GiftCard giftCard)throws DuplicateGiftCardIdException {
		Optional<GiftCard>registerIdObj= giftCardRepository.findById(giftCard.getGiftCardId());
		if(registerIdObj.isPresent()) {
			throw new DuplicateGiftCardIdException("This GiftCard Id"+giftCard.getGiftCardId()+"is already exist");
		}
        return giftCardRepository.save(giftCard);
		}
	
	

	@Override
	public GiftCard updateGiftCardById(Integer giftCardId,GiftCard giftCard) throws InvalidIdException{
		Optional<GiftCard>updateGiftCardObj=giftCardRepository.findById(giftCardId);
		if(!updateGiftCardObj.isPresent()) {
			throw new InvalidIdException("Updating with invalid id! GiftCard with this Id  "+ giftCardId +" does not exist!");
		}
	   GiftCard giftCardUpdateByIdObj=giftCardRepository.findById(giftCardId).get();
	   giftCardUpdateByIdObj.setGiftCardId(giftCard.getGiftCardId());
//	   giftCardUpdateByIdObj.setGiftCardCustomizeMsg(giftCard.getGiftCardCustomizeMsg());
	   giftCardUpdateByIdObj.setBrand(giftCard.getBrand()); 
//	   giftCardUpdateByIdObj.setGiftCardName(giftCard.getGiftCardName());
//	   giftCardUpdateByIdObj.setAmount(giftCard.getAmount());
	
//	   giftCardUpdateByIdObj.setRedemptionDetails(giftCard.getRedemptionDetails());
		return giftCardRepository.save( giftCardUpdateByIdObj);
		
	}
	

	@Override
	public String deleteGiftCardById(Integer giftCardId) throws InvalidIdException {
		Optional<GiftCard>deleteGiftCardObj=giftCardRepository.findById(giftCardId);
		if(!deleteGiftCardObj.isPresent()) {
			throw new InvalidIdException("Deleting with invalid id ! GiftCard with this id "+ giftCardId+"  does not exist!");
		}
		giftCardRepository.deleteById(giftCardId);
		return "Gift Card With Id "+ giftCardId + " is successfully Deleted";
	}
}
