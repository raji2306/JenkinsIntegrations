package com.university.feemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.university.feemanagement.entities.Fee;
import com.university.feemanagement.entities.FeeDto;
import com.university.feemanagement.services.FeeService;

@Controller
public class FeeController {

	@Autowired
	private FeeService feeService;
	
	private static final String SAVEFEE="redirect:/admin/manageFees";

	
	@RequestMapping(value = "/")
	public ModelAndView home() {
		return new ModelAndView("home") ;
	}
	
	@RequestMapping(value = "/signin")
	public String customLogin(Model model, String error, String logout) {
		if(error != null) {
			model.addAttribute("error","You username or password is invalid");
		}
		if(logout != null) {
			model.addAttribute("message", "You have been logged out successfully");
		}
		return "login" ;
	}
	
	@RequestMapping(value = "/admin/manageFees")
	public ModelAndView manageFees() {
		List<Fee> lists = feeService.getAllFee();
		return new ModelAndView("manageFees", "feelist", lists) ;
	}
	
	
	@GetMapping(value="/admin/addFee")
	public String addFee(Model model) {
		model.addAttribute("fee", new Fee());
		return "addFee";
	}
	
	
	@PostMapping(value = "/admin/saveFee")
	public ModelAndView saveFee(@ModelAttribute FeeDto feedto) {
	    Fee fee=feedto.toEntity();
		feeService.saveOrUpdate(fee);
		return new ModelAndView(SAVEFEE);
	}
	
	@RequestMapping("/admin/deletefeebyid/{id}")
	public ModelAndView delete(@PathVariable("id") int feeId) {
		feeService.deleteFee(feeId);
		return new ModelAndView(SAVEFEE);
	}

	@GetMapping(value="/admin/editfee/{id}")
    public String edit(@PathVariable int id,ModelMap model){  
       Fee fee=feeService.getFeeById(id);  
       model.addAttribute("fee", fee);
	   return "editFee";
        
    } 
	
	@PostMapping(value="/admin/updateFee") 
    public String editsave(@ModelAttribute FeeDto feedto){ 
		Fee fee=feedto.toEntity();
    	feeService.saveOrUpdate(fee);
    	return SAVEFEE; 
    }  
	
	@RequestMapping(value="/admin/searchFee")  
    public ModelAndView searchFee(@RequestParam("keyword") String keyword){
		List<Fee> lists = feeService.listAll(keyword);
		return new ModelAndView("manageFees", "feelist", lists) ;
    }  
	

}
