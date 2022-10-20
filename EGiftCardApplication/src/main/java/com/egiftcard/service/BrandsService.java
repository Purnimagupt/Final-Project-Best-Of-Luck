package com.egiftcard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.egiftcard.entity.Brands;
import com.egiftcard.entity.PaymentDetails;
import com.egiftcard.exception.BrandNotFoundException;
import com.egiftcard.exception.DuplicateBrandIdException;
import com.egiftcard.exception.InvalidIdException;
import com.egiftcard.exception.NoDataException;
import com.egiftcard.exception.NoPaymentDetailsException;
import com.egiftcard.exception.NoSuchPaymentIdException;


public interface BrandsService {
	
	List<Brands> getAllBrands ();

	Brands registerBrands(Brands brands) throws DuplicateBrandIdException; 
	Brands updateBrandsById(int brandId, Brands brands) throws InvalidIdException ;
	Brands BrandsById(int brandId) throws BrandNotFoundException, InvalidIdException;
	String deleteBrandById(int brandId) throws NoDataException;
	
	
}
