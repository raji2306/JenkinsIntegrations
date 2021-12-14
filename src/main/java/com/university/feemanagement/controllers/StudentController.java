package com.university.feemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.university.feemanagement.entities.Student;
import com.university.feemanagement.entities.StudentDto;
import com.university.feemanagement.services.StudentService;
import com.university.feemanagement.services.UserService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studService;
	
	@Autowired
	private UserService userService;
	
	private static final String SAVESTUD="redirect:/admin/manageStudents";
	
	@RequestMapping(value = "/admin/manageStudents")
	public ModelAndView manageStudents() {
		List<Student> lists = studService.getAllStudent();
		ModelMap map= new ModelMap();
		map.addAttribute("studentlist", lists);
		return new ModelAndView("manageStudents", map) ;
	}
	
	@GetMapping(value = "/admin/addStudent")
	public String addStudent(ModelMap model) {
		model.addAttribute("student", new Student());
		return "addStudent2";
	}
	
	@PostMapping(value = "/admin/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute StudentDto studentdto) {
		Student student=studentdto.toEntity();
		userService.saveOrUpdate(student);
		studService.saveOrUpdate(student);
		return new ModelAndView(SAVESTUD);
	}
	
	@RequestMapping("/admin/deletestudentbyid/{id}")
	public ModelAndView delete(@PathVariable("id") int studId) {
		studService.deleteStudent(studId);
		return new ModelAndView(SAVESTUD);
	}

	@GetMapping(value="/admin/editstudent/{id}")
    public String edit(@PathVariable int id,ModelMap model){  
       Student student=studService.getStudentById(id);  
       model.addAttribute("student", student);
	   return "editStudent";
        
    } 
	
	@PostMapping(value="/admin/updateStudent")
    public ModelAndView editsave(@ModelAttribute StudentDto studentdto){
		Student student=studentdto.toEntity();
    	studService.saveOrUpdate(student);  
    	return new ModelAndView(SAVESTUD); 
    }  
	
	@RequestMapping(value="/admin/searchStudent")  
    public ModelAndView searchStudent(@RequestParam("keyword") String keyword){
		List<Student> lists = studService.listAll(keyword);
		return new ModelAndView("manageStudents", "studentlist", lists) ;
    }   
	

}
