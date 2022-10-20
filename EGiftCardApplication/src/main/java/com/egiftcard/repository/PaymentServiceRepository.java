package com.egiftcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egiftcard.entity.PaymentDetails;

@Repository
public interface PaymentServiceRepository extends JpaRepository<PaymentDetails, Integer> {

}
