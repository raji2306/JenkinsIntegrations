package com.university.feemanagement.services;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.feemanagement.entities.Fee;
import com.university.feemanagement.entities.Student;
import com.university.feemanagement.repositories.StudentRepository;
import com.university.feemanagement.serviceinterfaces.StudentServiceInterface;

@Service
@Transactional
public class StudentService implements StudentServiceInterface{

	@Autowired
	private StudentRepository studRepo;
	
	private static final String HOSTEL="Hostel";
	private static final String TUITION="Tuition";
	private static final String TRANSPORT="Transport";
	private static final String CANTEEN="Canteen";
	
	@Override
	public List<Student> getAllStudent() {
		return studRepo.findAll();
	}

	@Override
	public void deleteStudent(int id) {
		studRepo.deleteById(id);
	}

	@Override
	public void saveOrUpdate(Student student) {
			Student stud = new Student();
			
			stud.setStudId(student.getStudId());
			
			stud.setFirstName(student.getFirstName());
			
			stud.setLastName(student.getLastName());
			
			stud.setDob(student.getDob());
			
			stud.setRrn(student.getRrn());
			
			stud.setBranch(student.getBranch());
			
			stud.setUniClass(student.getUniClass());
			
			stud.setSection(student.getSection());
			
			stud.setGender(student.getGender());
			
			stud.setEmail(student.getEmail());
			
			stud.setPhone(student.getPhone());
			
			stud.setAddress(student.getAddress());
			
			stud.setScholarship(student.getScholarship());
			
			stud.setScholarshipPercent(student.getScholarshipPercent());
			
			stud.setTransport(student.isTransport());
			
			stud.setHostel(student.isHostel());
			
			stud.setCanteen(student.isCanteen());
			
			stud.setAmount(student.getAmount());
			
			stud.setTransportRemAmt(student.getTransportRemAmt());
			
			stud.setHostelRemAmt(student.getHostelRemAmt());
			
			stud.setCanteenRemAmt(student.getCanteenRemAmt());
			
			stud.setTuitionRemAmt(student.getTuitionRemAmt());
			
			stud.setFees(student.getFees());
			
			
			studRepo.save(stud);
		
	}

	@Override
	public Student getStudentById(int id) {
		Optional<Student> list = studRepo.findById(id);
		Student s = null;
		if(list.isPresent()) {
			s = list.get();
		}
		return s;
	}

	public List<Student> listAll(String keyword) {
        if (keyword != null) {
            return studRepo.search(keyword);
        }
        return studRepo.findAll();
    }
	
	public float saveTotalFees(Student student) {
		Set<Fee> fee = student.getFees();
		float totFee = 0;
		if(student.getScholarship().equals("yes")) {
			for(Fee f : fee) {
			
				totFee += (f.getAmount() - (f.getAmount() * (student.getScholarshipPercent()/100)));
			}
		}
		else {
			for(Fee f : fee) {
				totFee += f.getAmount();
			}
		}
		
		student.setAmount(totFee);
	    saveOrUpdate(student);
		return totFee;
		
	}

	@Transactional
	public void setFeeStatus(Student student, Fee fee, boolean status) {
		if(status) {
			if(fee.getFeeName().equals(CANTEEN)) {
				student.setCanteenRemAmt(1);
			}else if(fee.getFeeName().equals(TRANSPORT)) {
				student.setTransportRemAmt(1);
			}else if(fee.getFeeName().equals(HOSTEL)) {
				student.setHostelRemAmt(1);
			}else if(fee.getFeeName().equals(TUITION)){
				student.setTuitionRemAmt(1);
			}
			
		}
		else {
			if(student.getScholarship().equals("yes")) {
				setScholarshipAmt(student, fee);
			}else {
				setStandardAmt(student, fee);
			}
		}
		saveOrUpdate(student);
		
	}
	
	public void setScholarshipAmt(Student student, Fee fee) {
		float remAmount = fee.getAmount() - (fee.getAmount() * student.getScholarshipPercent()/100);
		if(fee.getFeeName().equals(CANTEEN)) {
			if(student.getCanteenRemAmt() == (remAmount/2)) {
				student.setCanteenRemAmt(1);
			}
			student.setCanteenRemAmt(remAmount/2);
		}else if(fee.getFeeName().equals(TRANSPORT)) {
			if(student.getTransportRemAmt() == (remAmount/2)) {
				student.setTransportRemAmt(1);
			}
			student.setTransportRemAmt(remAmount/2);
		}else if(fee.getFeeName().equals(HOSTEL)) {
			if(student.getHostelRemAmt() == (remAmount/2)) {
				student.setHostelRemAmt(1);
			}
			student.setHostelRemAmt(remAmount/2);
		}else if(fee.getFeeName().equals(TUITION)){
			if(student.getTuitionRemAmt() == (remAmount/2)) {
				student.setTuitionRemAmt(1);
			}
			student.setTuitionRemAmt(remAmount/2);
		}
	}
	
	public void setStandardAmt(Student student, Fee fee) {
		float remAmount = fee.getAmount();
		if(fee.getFeeName().equals(CANTEEN)) {
			if(student.getCanteenRemAmt() == (remAmount/2)) {
				student.setCanteenRemAmt(1);
			}
			student.setCanteenRemAmt(remAmount/2);
		}else if(fee.getFeeName().equals(TRANSPORT)) {
			if(student.getTransportRemAmt() == (remAmount/2)) {
				student.setTransportRemAmt(1);
			}
			student.setTransportRemAmt(remAmount/2);
		}else if(fee.getFeeName().equals(HOSTEL)) {
			if(student.getHostelRemAmt() == (remAmount/2)) {
				student.setHostelRemAmt(1);
			}
			student.setHostelRemAmt(remAmount/2);
		}else if(fee.getFeeName().equals(TUITION)){
			if(student.getTuitionRemAmt() == (remAmount/2)) {
				student.setTuitionRemAmt(1);
			}
			student.setTuitionRemAmt(remAmount/2);
		}
	}
	
	public float getRemAmt(Student student,Fee f) {
		float amount = 0;
		if(f.getFeeName().equals(CANTEEN) && student.getCanteenRemAmt() != 1) {
			amount = student.getCanteenRemAmt();
		}else {
			amount =f.getAmount();
		}
		if(f.getFeeName().equals(TRANSPORT)  && student.getTransportRemAmt() != 1) {
			amount = student.getTransportRemAmt();
		}
		if(f.getFeeName().equals(HOSTEL)  && student.getHostelRemAmt() != 1) {
			amount = student.getHostelRemAmt();
		}
		if(f.getFeeName().equals(TUITION)  && student.getTuitionRemAmt() != 1) {
			amount = student.getTuitionRemAmt();
		}
		return amount;
	}
	
	public Set<Student> getFullPaidStudents() {
        return studRepo.getFullPaidStudents();
    }
	
	public Set<Student> getHalfPaidStudents() {
        return studRepo.getHalfPaidStudents();
    }
	
	public Integer getTotalStudents() {
        return studRepo.getTotalStudents();
    }
	
	public Integer getTransportStudents() {
		return studRepo.getTransportStudents();
	}
	
	public Integer getTransportPaidStudents() {
		return studRepo.getTransportPaidStudents();
	}
	
	public Integer getCanteenStudents() {
		return studRepo.getCanteenStudents();
	}
	
	public Integer getCanteenPaidStudents() {
		return studRepo.getCanteenPaidStudents();
	}
	
	public Integer getHostelStudents() {
		return studRepo.getHostelStudents();
	}
	
	public Integer getHostelPaidStudents() {
		return studRepo.getHostelPaidStudents();
	}
	
	public Integer getTuitionPaidStudents() {
		return studRepo.getTuitionPaidStudents();
	}
	
	public Student findByRrn(long rrn) {
		return studRepo.findByRrn(rrn);
	}

	
}
