package com.msproject.hrworker.entities.DTO;




public class WorkerDTO {
	Long id;
	String name;
	Double dailyIncome;
	
	public WorkerDTO(){}	
	
	public WorkerDTO(Long id, String name, Double dailyIncome) {
		super();
		this.id = id;
		this.name = name;
		this.dailyIncome = dailyIncome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getDailyIncome() {
		return dailyIncome;
	}
	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	
	
	
}
