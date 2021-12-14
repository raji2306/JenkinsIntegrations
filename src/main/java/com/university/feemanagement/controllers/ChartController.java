package com.university.feemanagement.controllers;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.university.feemanagement.entities.Fee;
import com.university.feemanagement.entities.Student;
import com.university.feemanagement.services.FeeService;
import com.university.feemanagement.services.StudentService;

@Controller
public class ChartController {

	@Autowired
	private StudentService studService;
	
	@Autowired
	private FeeService feeService;
	
	@GetMapping("/student/dashboard")
	public String data1(Model model) {
		
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); 
	    String[] splitString = name.split("@"); 
	    long rrn = Long.parseLong(splitString[0]); 
	    Student student=studService.findByRrn(rrn);
		 
	    
	    Set<Fee> allBranchFees = feeService.getAllBranchFees();
		
		    
		
		String branch = student.getBranch();
		Fee branchFee = feeService.getBranchFees(branch);
		allBranchFees.add(branchFee);
		
			
		Fee transportFee = null;
		if(student.isTransport()) {
			transportFee = feeService.getFeesByName("Transport");
			allBranchFees.add(transportFee);
		}
			
		Fee hostelFee = null;
		if(student.isHostel()) {
			hostelFee = feeService.getFeesByName("Hostel");
			allBranchFees.add(hostelFee);
		}
			
		Fee canteenFee = null;
		if(student.isCanteen()) {
			canteenFee = feeService.getFeesByName("Canteen");
			allBranchFees.add(canteenFee);
		}
		
		
		student.setFees(allBranchFees);
		studService.saveTotalFees(student);
		studService.saveOrUpdate(student);
		
	    
		Map<String, Float[]> graphData = new TreeMap<>();
		 
		Set<Fee> getFee = student.getFees();
		for(Fee f : getFee) {
			float remAmt = studService.getRemAmt(student, f);
			Float[] amt = {f.getAmount(), remAmt};
			graphData.put(f.getFeeName(), amt);
		}
		model.addAttribute("student", student);
		model.addAttribute("chartData", graphData);
		return "thymeleaf/dashboard";
	}
	
	@GetMapping("/admin/dashboard")
	public ModelAndView data2(ModelMap model) {
		
	    
		Map<String, Integer> graphData = new TreeMap<>();
		Integer totStud = studService.getTotalStudents();
		
		Set<Student> fullPaidStudentSet = studService.getFullPaidStudents();
		
		
		Integer paidStud = fullPaidStudentSet.size();
		Integer unpaidStud = totStud - paidStud;
		graphData.put("Unpaid Students", paidStud);
		graphData.put("Paid Students", unpaidStud);
		model.addAttribute("chartData", graphData);
		
		Map<String, Integer[]> feeData = new TreeMap<>();
		Integer[] transportStudDet= {studService.getTransportStudents(),studService.getTransportPaidStudents()};
		feeData.put("Transport", transportStudDet);
		Integer[] hostelStudDet= {studService.getHostelStudents(),studService.getHostelPaidStudents()};
		feeData.put("Hostel", hostelStudDet);
		Integer[] canteenStudDet= {studService.getCanteenStudents(),studService.getCanteenPaidStudents()};
		feeData.put("Canteen", canteenStudDet);
		Integer[] tuitionStudDet= {studService.getTotalStudents(),studService.getTuitionPaidStudents()};
		feeData.put("Tuition", tuitionStudDet);
		model.addAttribute("barData", feeData);
		model.addAttribute("totStudents", totStud);
		
	
		return new ModelAndView("thymeleaf/dash", model);
	}
	
	
	

}