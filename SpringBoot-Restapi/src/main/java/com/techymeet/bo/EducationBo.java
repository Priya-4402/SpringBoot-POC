package com.techymeet.bo;

public class EducationBo {
	private int educationId;
	private String educationDetails;
	private StudentBo studentBo;
	

	
	
	public StudentBo getStudentBo() {
		return studentBo;
	}
	public void setStudentBo(StudentBo studentBo) {
		this.studentBo = studentBo;
	}

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
