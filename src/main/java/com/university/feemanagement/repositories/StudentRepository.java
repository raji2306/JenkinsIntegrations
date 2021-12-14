package com.university.feemanagement.repositories;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.university.feemanagement.entities.Student;



public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query("SELECT s FROM Student s WHERE CONCAT(s.firstName, s.lastName, s.rrn, s.branch, s.uniClass, s.email, s.phone) LIKE %?1%")
	public List<Student> search(String keyword);
	
	@Query("SELECT s FROM Student s WHERE s.transportRemAmt = 1 AND s.canteenRemAmt = 1 "
			+ "AND s.hostelRemAmt = 1 AND s.tuitionRemAmt = 1")
	public Set<Student> getFullPaidStudents();
	
	@Query("SELECT s FROM Student s WHERE s.transportRemAmt != 0 AND s.transportRemAmt != 1 AND s.canteenRemAmt != 0 "
			+ "AND s.canteenRemAmt != 1 AND s.hostelRemAmt != 0 AND s.hostelRemAmt != 1 AND s.tuitionRemAmt != 0"
			+ "AND s.tuitionRemAmt != 1")
	public Set<Student> getHalfPaidStudents();
	
	@Query("SELECT count(*) FROM Student")
	public Integer getTotalStudents();
	
	@Query("SELECT count(*) FROM Student s WHERE s.transport = true")
	public Integer getTransportStudents();
	
	@Query("SELECT count(*) FROM Student s WHERE s.transportRemAmt = 1 ")
	public Integer getTransportPaidStudents();
	
	@Query("SELECT count(*) FROM Student s WHERE s.canteen = true")
	public Integer getCanteenStudents();
	
	@Query("SELECT count(*) FROM Student s WHERE s.canteenRemAmt = 1 ")
	public Integer getCanteenPaidStudents();
	
	@Query("SELECT count(*) FROM Student s WHERE s.hostel = true")
	public Integer getHostelStudents();
	
	@Query("SELECT count(*) FROM Student s WHERE s.hostelRemAmt = 1 ")
	public Integer getHostelPaidStudents();
	
	@Query("SELECT count(*) FROM Student s WHERE s.tuitionRemAmt = 1 ")
	public Integer getTuitionPaidStudents();
	
	public Student findByRrn(long rrn);
	
}

