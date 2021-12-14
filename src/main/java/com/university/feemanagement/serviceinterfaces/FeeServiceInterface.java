package com.university.feemanagement.serviceinterfaces;

import java.util.List;

import com.university.feemanagement.entities.Fee;


public interface FeeServiceInterface {

	public List<Fee> getAllFee();
	public void deleteFee(int id);
	public void saveOrUpdate(Fee fee);
	public Fee getFeeById(int id);
}
