package cam.bank;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.model.Account;
import com.bank.model.ServiceResponse;
import com.bank.model.Transaction;

@FeignClient
public interface ITransactionFeign {
	@RequestMapping(value="/transaction/{mutualFund}", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<Transaction>> makeTransaction(@RequestBody Account account, @PathVariable("mutualFund") String mutualFund);
}
