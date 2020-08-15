package com.bank.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bank.exception.BankException;
import com.bank.model.ServiceResponse;
import com.bank.model.ServiceResponse.Errors;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ResponseHandlers<T> {

	public <R> ResponseEntity<R> defaultResponse(T data){
		ServiceResponse<T> responseModel = (ServiceResponse<T>) ServiceResponse.builder()
																	.success(true)
																	.data(data)
																	.build();
		return new ResponseEntity<R>((R) responseModel, HttpStatus.OK);
	}
	
	public <R> ResponseEntity<R> defaultResponse(T data, String message){
		ServiceResponse<T> responseModel = (ServiceResponse<T>) ServiceResponse.builder()
																	.success(true)
																	.additionalMessage(message)
																	.data(data)
																	.build();
		return new ResponseEntity<R>((R) responseModel, HttpStatus.OK);
	}
	
	public <R> ResponseEntity<ServiceResponse<R>> handleExceptions(BankException ex) {
		ServiceResponse<T> responseModel = (ServiceResponse<T>) ServiceResponse.builder()
				.success(false)
				.error(
						Errors.builder()
						.errorCode(ex.getErrorCode())
						.errorMessage(ex.getErrorMessage())
						.build()
				)
				.build();
		return new ResponseEntity<ServiceResponse<R>>((ServiceResponse<R>) responseModel, ex.getErrorCode());
	}
}
