package com.egiftcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egiftcard.entity.GiftCard;

@Repository
public interface GiftCardManagementRepository extends JpaRepository<GiftCard, Integer>{

}
