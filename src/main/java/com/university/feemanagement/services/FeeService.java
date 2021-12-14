package com.university.feemanagement.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.feemanagement.entities.Fee;
import com.university.feemanagement.repositories.FeeRepository;
import com.university.feemanagement.serviceinterfaces.FeeServiceInterface;

@Service
@Transactional
public class FeeService implements FeeServiceInterface{

	@Autowired
	private FeeRepository feeRepo;
	
	@Override
	public List<Fee> getAllFee() {
		return feeRepo.findAll();
	}

	@Override
	public void deleteFee(int id) {
		feeRepo.deleteById(id);
	}

	@Override
	public void saveOrUpdate(Fee fee) {
		Fee fee1 = new Fee();
		
		fee1.setFeeId(fee.getFeeId());
		
		fee1.setFeeName(fee.getFeeName());
		
		fee1.setBranch(fee.getBranch());
		
		fee1.setAmount(fee.getAmount());
		
		fee1.setDueDate(fee.getDueDate());
		
		feeRepo.save(fee1);
		
	}

	@Override
	public Fee getFeeById(int id) {
		Optional<Fee> list = feeRepo.findById(id);
		Fee f = null;
		if(list.isPresent()) {
			f = list.get();
		}
		return f;
	}

	public List<Fee> listAll(String keyword) {
       if (keyword != null) {
           return feeRepo.search(keyword);
       }
       return feeRepo.findAll();
   }
	
	
	public Set<Fee> getAllBranchFees() {
		Set<Fee> fee = feeRepo.getAllBranchFees();
		Set<Fee> rem = new HashSet<>();
		for(Fee f: fee) {
			if(f.getFeeName().equals("Transport") || f.getFeeName().equals("Hostel") || 
					f.getFeeName().equals("Canteen")) {
				rem.add(f);
			}
			
		}
		fee.removeAll(rem);
		return fee;
	}
	
	public Fee getFeesByName(String name) {
		return feeRepo.findByFeeName(name);
	}

	public Fee getBranchFees(String branch) {
		return feeRepo.getBranchFees(branch);
		
	}
	
	
}

