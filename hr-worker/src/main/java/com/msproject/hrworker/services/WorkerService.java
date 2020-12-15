package com.msproject.hrworker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.msproject.hrworker.entities.Worker;
import com.msproject.hrworker.entities.DTO.WorkerDTO;
import com.msproject.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;
	
	
//	public Worker editWorker(Long workerId, WorkerDTO workerDTO) {
//		
////		Worker editedWorker = repository.findOne( Example.of ( Worker.build()
////                .codigo ( codigo ).build () ) ).orElseThrow ( () -> new RPPSResourceNotFoundException ( "Aderência não encontrada" ) );
//
//		
//		Worker worker = repository.findById(workerId).get();
//		worker.setName(workerDTO.getName());
//		worker.setDailyIncome(workerDTO.getDailyIncome());
//		
//		return worker;
//	}
	
}
