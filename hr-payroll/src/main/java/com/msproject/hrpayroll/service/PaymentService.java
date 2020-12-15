package com.msproject.hrpayroll.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msproject.hrpayroll.entities.Payment;
import com.msproject.hrpayroll.entities.Worker;
import com.msproject.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	
	@Autowired
	private WorkerFeignClient feignClient;
	
	public Payment getPayment(Long workerId, Integer days) {
		
				
		Worker worker = feignClient.findAllbyId(workerId).getBody();	
		return new Payment(worker.getName(), worker.getDailyIncome() , days);
	}

}
