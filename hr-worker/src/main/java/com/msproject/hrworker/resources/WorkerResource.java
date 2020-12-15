package com.msproject.hrworker.resources;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msproject.hrworker.entities.Worker;
import com.msproject.hrworker.repositories.WorkerRepository;
import com.msproject.hrworker.services.WorkerService;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerService service;
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping("/configs")
	public ResponseEntity<Void> getConfig() {
		logger.info("Config = "+ testConfig);
		
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<Page<Worker>> findAllPageable(            
			@RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "page", defaultValue = "0") int page) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Worker> list = repository.findAll(pageable);
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findAllbyId(@PathVariable("id")Long id) {
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
//	@PutMapping(value ="editWorker/{id}")
//	public ResponseEntity<Worker> editWorkerById(@PathVariable("id")Long id,
//			@Valid @RequestBody Worker worker){
//		
//		worker = service.editWorker(id,worker);
//		return ResponseEntity.ok(repository.save(worker));
//	}
//	
}
