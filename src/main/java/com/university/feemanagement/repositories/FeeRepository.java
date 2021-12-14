package com.university.feemanagement.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.university.feemanagement.entities.Fee;



public interface FeeRepository extends JpaRepository<Fee, Integer>{

	@Query("SELECT f FROM Fee f WHERE CONCAT(f.feeName,f.branch, f.amount, f.dueDate) LIKE %?1%")
	public List<Fee> search(String keyword);
	
	@Query("SELECT f FROM Fee f WHERE f.branch = 'All'")
	public Set<Fee> getAllBranchFees();
	
	@Query("SELECT f FROM Fee f WHERE f.feeName = 'Tuition' AND f.branch = ?1")
	public Fee getBranchFees(String branch);
	
	public Fee findByFeeName(String name);
	
	
}

