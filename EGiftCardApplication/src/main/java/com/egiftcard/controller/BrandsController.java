package com.egiftcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard.entity.Brands;
import com.egiftcard.entity.PaymentDetails;
import com.egiftcard.exception.BrandNotFoundException;
import com.egiftcard.exception.DuplicateBrandIdException;
import com.egiftcard.exception.InvalidIdException;
import com.egiftcard.exception.NoDataException;
import com.egiftcard.service.BrandsService;

@RestController
@RequestMapping("/giftbrands")
@CrossOrigin
public class BrandsController {

	@Autowired
	private BrandsService brandsService;
	
	@SuppressWarnings("unchecked")
	@GetMapping()
	public ResponseEntity<List<Brands>> getAllBrands() {
		List<Brands> brand = brandsService.getAllBrands();
			return new ResponseEntity<>(brand, HttpStatus.OK);
	}

	
	@GetMapping("/{brandId}")
	public ResponseEntity<Brands>BrandsById(@PathVariable int brandId) throws BrandNotFoundException, InvalidIdException{
		Brands brandsObject1=brandsService.BrandsById(brandId);
		return new ResponseEntity<Brands>(brandsObject1,HttpStatus.OK);
	}
	
	//http://localhost:8080/EGiftCardApp/api/giftbrands
	@PostMapping()
	public ResponseEntity<Brands>registerBrands(@RequestBody Brands brands) throws DuplicateBrandIdException{
		Brands brandsObject=brandsService.registerBrands(brands);
		return  ResponseEntity.ok(brandsObject);
		
	}
	
	//http://localhost:8080/EGiftCardApp/api/giftbrands/2
	@PutMapping(value = "/{brandId}")
	public ResponseEntity<Brands> updateBrandsById(@PathVariable int brandId,
			 @RequestBody Brands brands) throws InvalidIdException {

		return new ResponseEntity<Brands>(brandsService.updateBrandsById(brandId, brands),
				HttpStatus.ACCEPTED);

	}
	
	@DeleteMapping("/{brandId}")
	public ResponseEntity<String> deleteUserById(@PathVariable("brandId") int brandId) throws NoDataException {
		if (brandId == 0)
			throw new NoDataException("data not available");
		else {
			brandsService.deleteBrandById(brandId);
			return new ResponseEntity<String>("Deleted user with id " + brandId + " successfully", HttpStatus.OK);
		}
	}
}
