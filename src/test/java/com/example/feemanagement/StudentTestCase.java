package com.example.feemanagement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.university.feemanagement.entities.Student;
import com.university.feemanagement.repositories.StudentRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
@Rollback(true)
class StudentTestCase {

	@Autowired
	private StudentRepository repo;
	
	@Test
	@Order(1)
	void testCreateStudent() {
		Student s=new Student();
		 s.setAddress("No:12 nethaji nagar"); s.setFirstName("Priya");
		  s.setLastName("Raj"); s.setAmount(0); s.setBranch("IT"); s.setCanteen(true);
		  s.setDob("2000-02-28"); s.setEmail("abc@gmail.com"); s.setGender("female");
		  s.setHostel(true); s.setPhone("9783387632"); s.setRrn(111517106106L);
		  s.setScholarship("yes"); s.setScholarshipPercent(25); s.setSection("B");
		  s.setTransport(false); s.setTransportRemAmt(20000);
		  s.setTuitionRemAmt(20000); s.setHostelRemAmt(20000);
		  s.setCanteenRemAmt(20000); s.setUniClass("MBA");
	    Student savedStudent=repo.save(s);
	    Assertions.assertNotNull(savedStudent);
	}
	
	
	@Test
	@Order(2)
	void testGetStudentById() {
		int id=1 ;
		Optional<Student> list=repo.findById(id);
		Student s = null;
		if(list.isPresent()) {
			s = list.get();
		}
		assertThat(s.getStudId()).isEqualTo(id);
	}
		
	
	@Test
	@Order(3)
    void testListStudents() {
		List<Student> students=(List<Student>)repo.findAll();
		assertThat(students.size()).isPositive();
	}
	
	@Test
	@Order(4)
	void testDeleteStudent() {
		int id=1;
		boolean isExistBeforeDelete=repo.findById(id).isPresent();
		repo.deleteById(id);
		boolean notExistAfterDelete=repo.findById(id).isPresent();
		Assertions.assertTrue(isExistBeforeDelete);
		Assertions.assertFalse(notExistAfterDelete);
	}

	
}
