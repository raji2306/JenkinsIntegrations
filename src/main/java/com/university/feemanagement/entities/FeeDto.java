package com.university.feemanagement.entities;

import java.util.HashSet;
import java.util.Set;

public class FeeDto{

	
	private int feeId;
	
	private String feeName;
	
	private String branch;
	
	private String dueDate;
	
	private float amount;
	
    private Set<Student> student = new HashSet<>();
	
	public FeeDto() {
		super();
	}
	
	

	public FeeDto(int feeId, String feeName, String branch, String dueDate, float amount) {
		super();
		this.feeId = feeId;
		this.feeName = feeName;
		this.branch = branch;
		this.dueDate = dueDate;
		this.amount = amount;
	}



	public int getFeeId() {
		return feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	
	public Fee toEntity() {
        Fee entity = new Fee();

        entity.setAmount(this.amount);
        entity.setBranch(this.branch);
        entity.setDueDate(this.dueDate);
        entity.setFeeId(this.feeId);
        entity.setFeeName(this.feeName);
        entity.setStudent(this.student);
        
        return entity;
    }
	
}

