//package com.egiftcard;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.egiftcard.entity.GiftCard;
//import com.egiftcard.exception.DuplicateGiftCardIdException;
//import com.egiftcard.exception.GiftCardNotFoundException;
//import com.egiftcard.exception.InvalidIdException;
//import com.egiftcard.repository.GiftCardManagementRepository;
//import com.egiftcard.service.IGiftCardManagementService;
//
//@SpringBootTest
//class GiftCardManagementTests {
//
//	@Autowired
//	private IGiftCardManagementService giftCardService;
//
//	@MockBean
//	private GiftCardManagementRepository giftCardRepository;
//
//	@Test
//	void getAllGiftCardsTest() {
//		GiftCard giftCard = new GiftCard(24, "GiftCard AS belssing", "bhnn", "purnima", 200, 100, "nothing");
//		List<GiftCard> listGift = new ArrayList<>();
//		listGift.add(giftCard);
//		when(giftCardRepository.findAll()).thenReturn(listGift);
//		assertEquals(1, giftCardService.getAllGiftCards().size());
//	}
//
//	@Test
//	void registerGiftCardTest() throws DuplicateGiftCardIdException {
//		GiftCard gift = new GiftCard(24, "GiftCard AS belssing", "bhnn", "purnima", 200, 100, "nothing");
//		when(giftCardRepository.save(gift)).thenReturn(gift);
//		assertEquals(gift, giftCardService.registerGiftCard(gift));
//	}
//
//	@Test
//	void findByIdGiftCardTest() throws GiftCardNotFoundException, InvalidIdException {
//		Optional<GiftCard> gift = Optional
//				.of(new GiftCard(23, "It is good", "Myntrabrand", "purnima", 200, 100, "nothing"));
//		GiftCard gift1 = gift.get();
//		when(giftCardRepository.findById(23)).thenReturn(gift);
//		assertEquals(gift1, giftCardService.getGiftCardById(23));
//	}
//
//	@Test
//	void deleteGiftCard() throws InvalidIdException {
//		giftCardRepository.deleteById(23);
//		verify(giftCardRepository, times(1)).deleteById(23);
//	}
//
//	@Test
//	void testFindByIdShouldThrowGiftCardNotFoundException() {
//		assertThrows(GiftCardNotFoundException.class, () -> {
//			giftCardService.getGiftCardById(23);
//		});
//	}
//}
