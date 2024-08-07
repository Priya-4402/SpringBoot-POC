package com.techymeet.vo;
import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity

public class EducationVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationId;
	private String educationDetails;
	@OneToOne
	private StudentVo student;
	
//	private int id;
//	private String name;
//	private String gender;
//	private String email;
//	private String password;
//	private String dateOfBirth;
//	private String address;
//	private String city;
//	private String country;
	
public StudentVo getStudent() {
		return student;
	}
	public void setStudent(StudentVo student) {
		this.student = student;
	}
	//public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getDateOfBirth() {
//		return dateOfBirth;
//	}
//	public void setDateOfBirth(String dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public String getCountry() {
//		return country;
//	}
//	public void setCountry(String country) {
//		this.country = country;
//	}
//		@OneToOne
//	private StudentVo stu;
//	
//	public StudentVo getStu() {
//		return stu;
//	}
//	public void setStu(StudentVo stu) {
//		this.stu = stu;
//	}
	public int getEducationId() {
		return educationId;
	}
	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}
	public String getEducationDetails() {
		return educationDetails;
	}
	public void setEducationDetails(String educationDetails) {
		this.educationDetails = educationDetails;
	}
	
	
	

}
