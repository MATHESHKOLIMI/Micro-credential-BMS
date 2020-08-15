package com.bank.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<ErrorDetails> customerNotFoundException(CustomerNotFoundException exc,WebRequest request){
		ErrorDetails errordetails=new ErrorDetails(new Date(), exc.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
	}
}
