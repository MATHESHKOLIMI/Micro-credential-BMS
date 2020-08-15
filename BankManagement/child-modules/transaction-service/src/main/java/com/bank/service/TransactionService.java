package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.config.BanksProperties;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	BanksProperties banks;

	/*@Override
	public Payment checkPayment(Payment payment) {
		Bank userBank = banks.getBanksMappings().get(payment.getBankName().toUpperCase());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		//Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		// Note: here we are making this converter to process any kind of response, 
		// not only application/*json, which is the default behaviour
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));        
		messageConverters.add(converter); 
		restTemplate.setMessageConverters(messageConverters); 
		Payment receivedPayment = null;
		try {
			ResponseEntity<Payment> exchange = restTemplate.exchange(userBank.getFullUrl(), HttpMethod.GET, entity, Payment.class);
			
			if(exchange.getStatusCode().is2xxSuccessful()) {
				receivedPayment = Optional.ofNullable(exchange.getBody()).get();
				if(!Objects.isNull(receivedPayment.getFailure()) && receivedPayment.getFailure().getFailureCode() != 0) {
					throw new BusReservationException(HttpStatus.INTERNAL_SERVER_ERROR, receivedPayment.getFailure().getMessage());
				}
			}else {
				throw new BusReservationException(HttpStatus.SERVICE_UNAVAILABLE, "Gateway Down!!!");
			}
		}catch(Exception ex) {
			throw new BusReservationException(HttpStatus.BAD_GATEWAY, "Gateway Down!!!");
		}
		return Optional.of(receivedPayment)
				.filter(pay->!Objects.isNull(pay))
				.orElseThrow(()-> new BusReservationException(HttpStatus.INTERNAL_SERVER_ERROR, "Gateway Down!!!"));
	} */

}
