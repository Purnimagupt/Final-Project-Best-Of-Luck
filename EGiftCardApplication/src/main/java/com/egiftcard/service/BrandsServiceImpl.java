package com.egiftcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiftcard.entity.Brands;
import com.egiftcard.entity.PaymentDetails;
import com.egiftcard.exception.BrandNotFoundException;
import com.egiftcard.exception.DuplicateBrandIdException;
import com.egiftcard.exception.InvalidIdException;
import com.egiftcard.exception.NoDataException;
import com.egiftcard.repository.BrandsRepository;

@Service
public class BrandsServiceImpl implements BrandsService{

	@Autowired
	private BrandsRepository brandsRepo;
	
	@Override
	public List<Brands> getAllBrands() {
				return brandsRepo.findAll();
	}

	@Override
	public Brands registerBrands(Brands brands) throws DuplicateBrandIdException {
	Optional<Brands>brandOps=brandsRepo.findById(brands.getBrandId());
	if(brandOps.isPresent()) {
		throw new DuplicateBrandIdException("This GiftCard Id" +brands.getBrandId()+ "is already exist");
	}
		
		return brandsRepo.saveAndFlush(brands);
	}

	@Override
	public Brands updateBrandsById(int brandId, Brands brands) throws InvalidIdException {
		Optional<Brands> updateBrands = brandsRepo.findById(brandId);
		if (!updateBrands.isPresent()) {
			throw new InvalidIdException(
					"Updating with invalid id! Brand with this Id  " + brandId + " does not exist!");
		}
		Brands UpdateBrands = brandsRepo.findById(brandId).get();
		UpdateBrands.setBrandDescription(brands.getBrandDescription());
		UpdateBrands.setBrandId(brands.getBrandId());
		UpdateBrands.setBrandName(brands.getBrandName());
		UpdateBrands.setImageUrl(brands.getImageUrl());
		
		return brandsRepo.saveAndFlush(UpdateBrands);
	}

	@Override
	public Brands BrandsById(int brandId) throws BrandNotFoundException, InvalidIdException {
		Optional<Brands> brandsObj = brandsRepo.findById(brandId);
		if (!brandsObj.isPresent()) {
			throw new BrandNotFoundException("Brand with this Id " + brandId + "  does not exist!");
		}
		if (brandId == 0 || brandId < 0) {
			throw new InvalidIdException("Invalid Id! Enter correct Id!");
		}
		return brandsObj.get();
	}
	
	@Override
	public String deleteBrandById(int brandId) throws NoDataException
	{
		Optional<Brands> brand=brandsRepo.findById(brandId);
		if (brand.isPresent()) {
			brandsRepo.deleteById(brandId);
			return "Data deleted";
		} else
			throw new NoDataException("DATA NOT AVAILABLE!! Please, Insert correct id to delete data");	
	}
	

}
