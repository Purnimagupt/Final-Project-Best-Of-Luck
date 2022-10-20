package com.egiftcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egiftcard.entity.Brands;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, Integer>{

}
