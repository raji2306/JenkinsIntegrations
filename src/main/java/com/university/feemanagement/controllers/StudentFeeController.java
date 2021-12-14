package com.university.feemanagement.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.university.feemanagement.entities.Fee;
import com.university.feemanagement.entities.Student;
import com.university.feemanagement.services.FeeService;
import com.university.feemanagement.services.StudentService;


@Controller
public class StudentFeeController {
	
	@Autowired
	private StudentService studService;
	
	@Autowired
	private FeeService feeService;
	
	private static final String HOSTEL="Hostel";
	private static final String TUITION="Tuition";
	private static final String TRANSPORT="Transport";
	private static final String CANTEEN="Canteen";
	
	
	@RequestMapping(value = "/student/myFees/{id}")
	public ModelAndView manageFees(@PathVariable("id") int studId) {
		
		Student student=studService.getStudentById(studId);
		
			
		Set<Fee> allBranchFees = student.getFees();
			
		Set<Fee> allBranchFees1 = getElemetsToRemove(student, allBranchFees);
		
		allBranchFees.removeAll(allBranchFees1);
		
		float amount = student.getAmount();
		if(student.getCanteenRemAmt() != 1) {
			amount = amount - student.getCanteenRemAmt();
		}else if(student.getCanteenRemAmt() == 1){
			float amt = feeService.getFeesByName(CANTEEN).getAmount();
			amount = amount - (amt - (amt * student.getScholarshipPercent()/100));
		}
		if(student.getTransportRemAmt() != 1) {
			amount = amount - student.getTransportRemAmt();
		}
		else if(student.getTransportRemAmt() == 1){
			float amt = feeService.getFeesByName(TRANSPORT).getAmount();
			amount = amount - (amt - (amt * student.getScholarshipPercent()/100));
		}
		if(student.getHostelRemAmt() != 1) {
			amount = amount - student.getHostelRemAmt();
		}
		else if(student.getHostelRemAmt() == 1){
			float amt = feeService.getFeesByName(HOSTEL).getAmount();
			amount = amount - (amt - (amt * student.getScholarshipPercent()/100));
		}
		if(student.getTuitionRemAmt() != 1) {
			amount = amount - student.getTuitionRemAmt();
		}
		else if(student.getTuitionRemAmt() == 1){
			float amt = feeService.getBranchFees(student.getBranch()).getAmount();
			amount = amount - (amt - (amt * student.getScholarshipPercent()/100));
		}
		ModelMap m = new ModelMap();
		
		Map<Fee, Float> feelist = new HashMap<>();
		if(student.getScholarship().equals("yes")) {
			for(Fee f: allBranchFees) {
				float amount1 = f.getAmount() - (f.getAmount() * (student.getScholarshipPercent()/100));
				feelist.put(f, amount1);
			}
		}else {
			for(Fee f: allBranchFees) {
				feelist.put(f, f.getAmount());
			}
		}
		
		m.addAttribute("feelist", feelist);
		m.addAttribute("amount", amount);
		m.addAttribute("student", student);
		return new ModelAndView("myFees", m) ;
		
	}
	
	public Set<Fee> getElemetsToRemove(Student student,Set<Fee> allBranchFees) {
		Set<Fee> allBranchFees1 = new HashSet<>();
		for(Fee f : allBranchFees) {
			if(f.getFeeName().equals(CANTEEN) && (student.getCanteenRemAmt() == 1)) {
				allBranchFees1.add(f);
			}
			if(f.getFeeName().equals(TUITION) && (student.getTuitionRemAmt() == 1)) {
				allBranchFees1.add(f);
			}
			if(f.getFeeName().equals(TRANSPORT) && (student.getTransportRemAmt() == 1)) {
				allBranchFees1.add(f);
			}
			if(f.getFeeName().equals(HOSTEL) && (student.getHostelRemAmt() == 1)) {
				allBranchFees1.add(f);
			}
		}
		return allBranchFees1;
		
	}
	
	
	@RequestMapping(value="/student/payment/{studId}/{feeId}") 
	  public ModelAndView fullPayment(@PathVariable int feeId, @PathVariable int studId){ 
		  ModelMap map = new ModelMap();
		  Student student=studService.getStudentById(studId);
		  Fee fee = feeService.getFeeById(feeId);
		  boolean status = true;
		  
		  if(fee.getFeeName().equals(CANTEEN) && student.getCanteenRemAmt() != 1
				  && student.getCanteenRemAmt() != 0) {
				status = false;
		  }
		  if(fee.getFeeName().equals(TRANSPORT) && student.getTransportRemAmt() != 1
				  && student.getTransportRemAmt() != 0) {
			    status = false;
		  }
		  if(fee.getFeeName().equals(HOSTEL) && student.getHostelRemAmt() != 1
				  && student.getHostelRemAmt() != 0) {
			  	status = false;
		  }
		  if(fee.getFeeName().equals(TUITION) && student.getTuitionRemAmt() != 1
				  && student.getTuitionRemAmt() != 0) {
			  	status = false;
		  }
		  Map<Fee, Float> feelist = new HashMap<>();
		  if(student.getScholarship().equals("yes")) {
			  float amount1 = fee.getAmount() - (fee.getAmount() * (student.getScholarshipPercent()/100));
			  feelist.put(fee, amount1);
		  }else {
			  feelist.put(fee, fee.getAmount()); 
		  }
		  map.addAttribute("status",status);
		  map.addAttribute("feelist",feelist);
		  map.addAttribute("student",student);
		  return new ModelAndView("paymentForm",map); 
	  }
	
	@GetMapping(value="/student/paymentSuccess/{studId}/{feeId}") 
	  public String fullPaymentSuccess(@RequestParam(name = "option", required = false, 
	  defaultValue="Full") String option, @PathVariable int studId,
			  @PathVariable int feeId){ 
		  Student student=studService.getStudentById(studId);
		  Fee fee = feeService.getFeeById(feeId);
		  if(option.equals("Full")) {
			  studService.setFeeStatus(student, fee, true);
		  }else {
			  studService.setFeeStatus(student, fee, false);
		  }
		  return "redirect:/student/myFees/{studId}";
	  }
	
	  
	  
	 
	
}
