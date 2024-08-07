package com.techymeet.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class LoginVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int loginId;
	private String email;
	private String password;
	@OneToOne
	private StudentVo student;
	
	public StudentVo getStudent() {
		return student;
	}
	public void setStudent(StudentVo student) {
		this.student = student;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
