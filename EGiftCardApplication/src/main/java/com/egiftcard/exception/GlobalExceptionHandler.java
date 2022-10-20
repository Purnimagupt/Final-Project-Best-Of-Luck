package com.egiftcard.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*@ControllerAdvice is a specialization of the @Component annotation which allows to 
handle exceptions across the whole application in one global handling component. 
It can be viewed as an interceptor of exceptions thrown by methods annotated with @RequestMapping and similar.
*/

@ControllerAdvice
public class GlobalExceptionHandler {

	// The @ExceptionHandler is an annotation used to handle the specific exceptions
	// and sending the custom responses to the client.
	@ExceptionHandler(DuplicateUserGiftDetailsIdException.class)
	public ResponseEntity<ExceptionResponse> duplicateIdExceptionHandler(DuplicateUserGiftDetailsIdException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(UserGiftDetailsNotFoundException.class)
	public ResponseEntity<ExceptionResponse> userGiftDetailNotFoundHandler(UserGiftDetailsNotFoundException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("NOT_FOUND");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	/*
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
	 * ResponseEntity<Map<String, String>>
	 * handleValidationExceptions(MethodArgumentNotValidException ex) { Map<String,
	 * String> errors = new HashMap<>();
	 * ex.getBindingResult().getAllErrors().forEach((error) -> { String fieldName =
	 * ((FieldError) error).getField(); String errorMessage =
	 * error.getDefaultMessage(); errors.put(fieldName, errorMessage); }); return
	 * new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST); }
	 */

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException e) {
		ExceptionResponse response = new ExceptionResponse();
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		String errorMessage = null;
		for (String key : errors.keySet()) {
			errorMessage = errors.get(key);
		}
		response.setErrorCode("BAD_REQUEST");
		response.setErrorMessage(errorMessage);
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchUserException.class)
	public ResponseEntity<ExceptionResponse> handleNoSuchUserException(NoSuchUserException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("CONFLICT");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);

	}

	@ExceptionHandler(InvalidUserIdException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidUserIdException(InvalidUserIdException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("IM_USED");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.IM_USED);
	}

	@ExceptionHandler(NoDataException.class)
	public ResponseEntity<ExceptionResponse> handleNoDataException(NoDataException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("GONE");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.GONE);
	}

	@ExceptionHandler(NoSuchPaymentIdException.class)
	public ResponseEntity<ExceptionResponse> handleDuplicateIDException(NoSuchPaymentIdException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("NOT_FOUND");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicatePaymentIdException.class)
	public ResponseEntity<ExceptionResponse> handleDuplicateIDException(DuplicatePaymentIdException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<>(response, HttpStatus.CONFLICT);
		return responseEntyity;
	}

	@ExceptionHandler(NoPaymentDetailsException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidDataException(NoPaymentDetailsException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("NOT_FOUND");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return responseEntyity;
	}

	@ExceptionHandler(DuplicateGiftCardIdException.class)
	public ResponseEntity<ExceptionResponse> handleDuplicateIDException(DuplicateGiftCardIdException exception) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(exception.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidIdException(InvalidIdException exception1) {
		ExceptionResponse response1 = new ExceptionResponse();
		response1.setErrorCode("NOT_ACCEPTABLE");
		response1.setErrorMessage(exception1.getMessage());
		response1.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response1, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(GiftCardNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleGiftCardNotFoundException(GiftCardNotFoundException exception2) {
		ExceptionResponse response2 = new ExceptionResponse();
		response2.setErrorCode("NOT_FOUND");
		response2.setErrorMessage(exception2.getMessage());
		response2.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response2, HttpStatus.NOT_FOUND);
	}
	
	
	

	@ExceptionHandler(NoReceivedDetailsFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNoReceivedDetailsFoundException(NoReceivedDetailsFoundException e) {

		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("CONFLICT");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response,HttpStatus.CONFLICT);

	}

	@ExceptionHandler(NoRedeemDetailsFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNoRedeemDetailsException(NoRedeemDetailsFoundException e) {

		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("CONFLICT");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response,HttpStatus.CONFLICT);

	}

	@ExceptionHandler(InvalidReceiveIdException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidReceiveIdException(InvalidReceiveIdException e) {

		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("CONFLICT");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response,HttpStatus.CONFLICT);

	}
	
	
	@ExceptionHandler(DuplicateBrandIdException.class)
	public ResponseEntity<ExceptionResponse> handleDuplicateBrandIDException(DuplicateBrandIdException exception) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(exception.getMessage());
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<ExceptionResponse>(response,
				HttpStatus.CONFLICT);
		return responseEntyity;
	}

	
	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleBrandNotFoundException(BrandNotFoundException exception2) {
		ExceptionResponse response2 = new ExceptionResponse();
		response2.setErrorCode("NOT_FOUND");
		response2.setErrorMessage(exception2.getMessage());
		response2.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<ExceptionResponse>(response2,
				HttpStatus.NOT_FOUND);
		return responseEntyity;
	}
	
	
}
