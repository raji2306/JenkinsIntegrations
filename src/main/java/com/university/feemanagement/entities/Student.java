package com.university.feemanagement.entities;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name = "student")
public class Student implements Serializable{

	private static final long serialVersionUID = -7531100697376474370L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studId;
	
	private String firstName;
	
	private String lastName;
	
	private String dob;
	
	private long rrn;
	
	private String branch;
	
	private String uniClass;
	
	private String section;
	
	private String gender;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private String scholarship;
	
	private float scholarshipPercent;
	
	private float amount;
	
	@ColumnDefault(value = "false")
	private boolean transport;
	
	@ColumnDefault(value = "1")
	private float transportRemAmt;
	
	@ColumnDefault(value = "false")
	private boolean hostel;
	
	@ColumnDefault(value = "1")
	private float hostelRemAmt;
	
	@ColumnDefault(value = "false")
	private boolean canteen;
	
	@ColumnDefault(value = "1")
	private float canteenRemAmt;
	
	@ColumnDefault(value = "1")
	private float tuitionRemAmt;
	
	
	
	public float getTuitionRemAmt() {
		return tuitionRemAmt;
	}

	public void setTuitionRemAmt(float tuitionRemAmt) {
		this.tuitionRemAmt = tuitionRemAmt;
	}

	@ManyToMany
    @JoinTable(
        name = "student_fee", 
        joinColumns = { @JoinColumn(name = "studId") }, 
        inverseJoinColumns = { @JoinColumn(name = "feeId") }
    )
    private Set<Fee> fees = new HashSet<>();
	
	

	public Student() {
		super();
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public long getRrn() {
		return rrn;
	}

	public void setRrn(long rrn) {
		this.rrn = rrn;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getUniClass() {
		return uniClass;
	}

	public void setUniClass(String uniClass) {
		this.uniClass = uniClass;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getScholarship() {
		return scholarship;
	}

	public void setScholarship(String scholarship) {
		this.scholarship = scholarship;
	}

	public float getScholarshipPercent() {
		return scholarshipPercent;
	}

	public void setScholarshipPercent(float scholarshipPercent) {
		this.scholarshipPercent = scholarshipPercent;
	}

	public boolean isTransport() {
		return transport;
	}

	public void setTransport(boolean transport) {
		this.transport = transport;
	}

	public boolean isHostel() {
		return hostel;
	}

	public void setHostel(boolean hostel) {
		this.hostel = hostel;
	}
	

	public boolean isCanteen() {
		return canteen;
	}

	public void setCanteen(boolean canteen) {
		this.canteen = canteen;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	
	public Set<Fee> getFees() {
		return fees;
	}

	public void setFees(Set<Fee> fees) {
		this.fees = fees;
	}

	public float getTransportRemAmt() {
		return transportRemAmt;
	}

	public void setTransportRemAmt(float transportRemAmt) {
		this.transportRemAmt = transportRemAmt;
	}

	public float getHostelRemAmt() {
		return hostelRemAmt;
	}

	public void setHostelRemAmt(float hostelRemAmt) {
		this.hostelRemAmt = hostelRemAmt;
	}

	public float getCanteenRemAmt() {
		return canteenRemAmt;
	}

	public void setCanteenRemAmt(float canteenRemAmt) {
		this.canteenRemAmt = canteenRemAmt;
	}
  
	public StudentDto toDto(Student s) {
		 StudentDto dto = new StudentDto();
		 dto.setAddress(s.getAddress());
		 dto.setAmount(s.getAmount());
		 dto.setBranch(s.getBranch());
		 dto.setCanteen(s.isCanteen());
		 dto.setCanteenRemAmt(s.getCanteenRemAmt());
		 dto.setDob(s.getDob());
		 dto.setEmail(s.getEmail());
		 dto.setFees(s.getFees());
		 dto.setFirstName(s.getFirstName());
		 dto.setGender(s.getGender());
		 dto.setHostel(s.isHostel());
		 dto.setHostelRemAmt(s.getHostelRemAmt());
		 dto.setLastName(s.getLastName());
		 dto.setPhone(s.getPhone());
		 dto.setRrn(s.getRrn());
		 dto.setScholarship(s.getScholarship());
		 dto.setScholarshipPercent(s.getScholarshipPercent());
		 dto.setSection(s.getSection());
		 dto.setStudId(s.getStudId());
		 dto.setTransport(s.isTransport());
		 dto.setTransportRemAmt(s.getTransportRemAmt());
		 dto.setTuitionRemAmt(s.getTuitionRemAmt());
		 dto.setUniClass(s.getUniClass());

	        return dto;
	    }
	
}

