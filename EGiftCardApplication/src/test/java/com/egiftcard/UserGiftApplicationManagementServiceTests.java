package com.egiftcard;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import com.egiftcard.entity.GiftCard;
import com.egiftcard.entity.User;
import com.egiftcard.entity.UserGiftDetails;
import com.egiftcard.repository.IUserGiftDetailsAccountManagementServiceRepository;
import com.egiftcard.service.UserGiftDetailsAccountManagementServiceImpl;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 class UserGiftApplicationManagementServiceTests {
	
	
	@Autowired
	private IUserGiftDetailsAccountManagementServiceRepository repo;
	
	
	@Test
	void contextLoads() {
	}
	/*
	@Test
	@Rollback(false)
	@Order(1)
	public void testAddUserGiftDetails() {
		UserGiftDetails userGiftDetails=new UserGiftDetails(10, 600, new Date(2022-9-19), false, "Adamya", 384756, "adam@gmail.com", "COD", LocalDate.of(2022, 9, 20),new User(),new GiftCard(),new Personalize());
		UserGiftDetails savedUserGiftDetails=repo.save(userGiftDetails);
		assertNotNull(savedUserGiftDetails);
	}
	
	
	@Test
	@Order(2)
	public void testGetUserDetailsById() {
		int id=1;
		UserGiftDetails userGiftDetails=repo.findById(id).get();
		assertThat(userGiftDetails.getUserGiftId()).isEqualTo(id);
	}
	
	@Test
	@Order(3)
	public void testGetAllUserGiftDetails() {
		List<UserGiftDetails> userGiftDetails=(List<UserGiftDetails>) repo.findAll();
		for(UserGiftDetails userGiftDet: userGiftDetails) {
			System.out.println(userGiftDet);
		}
		
		assertThat(userGiftDetails).size().isGreaterThan(0);
	}
	
	
	
	@Test
	@Rollback(false)
	@Order(4)
	public void testUpdateUserGiftDetail() {
		UserGiftDetails userGiftDetails=new UserGiftDetails(34, 600, new Date(2022-9-19), true, "Adamya", 384756, "adam@gmail.com", "COD", LocalDate.of(2022, 9, 20),new User(),new GiftCard(),new Personalize());
		repo.save(userGiftDetails);
		UserGiftDetails updatedUserGiftDetails=repo.findById(34).get();
		assertThat(updatedUserGiftDetails.getUserGiftId()).isEqualTo(34);
	}
		
	
	@Test
	@Rollback(false)
	@Order(5)
	public void testDeleteById() {
		int id=43;
		boolean isExistBeforeDelete=repo.findById(id).isPresent();
		repo.deleteById(id);
		boolean notExistAfterDelete=repo.findById(id).isPresent();
		assertTrue(isExistBeforeDelete);
		assertFalse(notExistAfterDelete);
	}
	
	*/
	
	
}
