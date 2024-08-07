package com.techymeet.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.techymeet.bo.EducationBo;
import com.techymeet.bo.LoginBo;
import com.techymeet.bo.StudentBo;

public interface StudentService {

	StudentBo createStudent(StudentBo student);

	List<StudentBo> findAllStudent();

	StudentBo getStudentById(int id);

	StudentBo updateStudent(StudentBo student);

	List<StudentBo> searchStudent(String name);

	int deleteStudentById(int id);

	StudentBo checkEmailExists(String email);


	StudentBo createEducation(EducationBo education, int id);

	LoginBo checkLogin(LoginBo login);

	EducationBo createEducation(EducationBo education);

	List<EducationBo> findAllEducation();

	EducationBo getEducationById(int educationId);

	EducationBo updateEducation(EducationBo education);

	public void uploadImg(MultipartFile file);

	//int deleteEducationById(int educationId);





	//StudentBo checkEmailExists(String email);

}
