package com.university.feemanagement.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fees")
public class Fee implements Serializable{

	private static final long serialVersionUID = 408918151641479492L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int feeId;

	private String feeName;
	
	private String branch;
	
	private String dueDate;
	
	private float amount;
	
	
	@ManyToMany(mappedBy = "fees")
    private Set<Student> student = new HashSet<>();
	
	public Fee() {
		super();
	}
	
	

	public Fee(int feeId, String feeName, String branch, String dueDate, float amount) {
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
	
	
	public FeeDto toDto(Fee f) {
		 FeeDto dto = new FeeDto();
		    dto.setAmount(f.getAmount());
		    dto.setBranch(f.getBranch());
		    dto.setDueDate(f.getDueDate());
		    dto.setFeeId(f.getFeeId());
		    dto.setFeeName(f.getFeeName());
		    dto.setStudent(f.getStudent());

	        return dto;
	    }
	
}

