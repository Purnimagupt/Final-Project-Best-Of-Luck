package com.egiftcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiftcard.entity.PaymentDetails;
import com.egiftcard.exception.DuplicatePaymentIdException;
import com.egiftcard.exception.NoDataException;
import com.egiftcard.exception.NoPaymentDetailsException;
import com.egiftcard.exception.NoSuchPaymentIdException;
import com.egiftcard.repository.PaymentServiceRepository;


@Service
public class PaymentServiceImpl implements IPaymentService{
	@Autowired
	private PaymentServiceRepository paymentRepo;
	
	@Override
	public List<PaymentDetails> getAllPaymentDetails(){
			return paymentRepo.findAll();
	}
	
	
	@Override
	public PaymentDetails getPaymentDetailsById(int paymentId) throws NoSuchPaymentIdException {
		
		Optional<PaymentDetails>pd=paymentRepo.findById(paymentId);
		if(!pd.isPresent()) {
			throw new NoSuchPaymentIdException("Sorry! Payment Id "+paymentId+" does not exists");	
		}
		return pd.get();}
	
	
	
	@Override
	public PaymentDetails registerPaymentDetails(PaymentDetails paymentDetails) throws DuplicatePaymentIdException {
		Optional<PaymentDetails> payDetails=paymentRepo.findById(paymentDetails.getPaymentID());
		if(payDetails.isPresent()) {
			throw new DuplicatePaymentIdException("Payment Details with Payment Id "+paymentDetails.getPaymentID()+" already exists");}
		return paymentRepo.save(paymentDetails);}
	
	
	
	

	@Override
	public PaymentDetails updatePaymentDetailsById(int paymentId, PaymentDetails paymentDetails) throws NoSuchPaymentIdException{
		
		Optional<PaymentDetails> paymentUpdate=paymentRepo.findById(paymentId);
		if(!paymentUpdate.isPresent()) {
			throw new NoSuchPaymentIdException("Payment Id "+paymentId+" does not exists");	
		}
		PaymentDetails paymentUpdateById= paymentRepo.findById(paymentId).get();
		paymentUpdateById.setCardExpiry(paymentDetails.getCardExpiry());
		paymentUpdateById.setCardNumber(paymentDetails.getCardNumber());
		paymentUpdateById.setCvv(paymentDetails.getCvv());
		paymentUpdateById.setNameOnCard(paymentDetails.getNameOnCard());
		paymentUpdateById.setPaymentAmount(paymentDetails.getPaymentAmount());
		paymentUpdateById.setPaymentDate(paymentDetails.getPaymentDate());
		return paymentRepo.save(paymentUpdateById);
		}
		

	

	@Override
	public String deletePaymentDetailsById(int paymentId) throws NoPaymentDetailsException   {
		Optional<PaymentDetails>pd=paymentRepo.findById(paymentId);
		if(pd.isPresent()) {
		paymentRepo.deleteById(paymentId);
		return "Deleted Successfully";
		}
		else 
			throw new NoPaymentDetailsException("No Payment Details Available! Please enter correct payment ID");
	}
}
