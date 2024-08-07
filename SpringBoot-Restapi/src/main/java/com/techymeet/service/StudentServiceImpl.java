package com.techymeet.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.techymeet.bo.EducationBo;
import com.techymeet.bo.LoginBo;
import com.techymeet.bo.StudentBo;
import com.techymeet.jparespository.EducationResository;
import com.techymeet.jparespository.ImageRepository;
import com.techymeet.jparespository.LoginRepository;
import com.techymeet.jparespository.StudentRepository;
import com.techymeet.vo.EducationVo;
import com.techymeet.vo.ImageEntity;
import com.techymeet.vo.LoginVo;
import com.techymeet.vo.StudentVo;
@Service
@Transactional

public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentrepository;
	@Autowired
	private EducationResository edurepository;
	@Autowired
	private ImageRepository imageRepository;
@Autowired 
private LoginRepository loginRepository;
	@Override
	public StudentBo createStudent(StudentBo student) {
		StudentVo studentVO = new StudentVo();
		BeanUtils.copyProperties(student, studentVO);
//		EducationVo edu=new EducationVo();
//	    edu.setEducationDetails(student.getEducationDetails());
//	   edu.setEducationId(student.getEducationId());
//	    studentVO.setEducation(edu);
		
		
//		 EducationVo educationVo = student.getEducationDetails();
//	        educationVo = educationRepository.save(educationVo);
//	        studentVO.setEducation(educationVo);
//		(
		LoginVo login=new  LoginVo();
		login.setEmail(student.getEmail());
		login.setPassword(student.getPassword());
		login.setStudent(studentVO);
		studentVO.setLogin(login);
		studentVO = studentrepository.save(studentVO);
		StudentBo createdStudent = new StudentBo();
		BeanUtils.copyProperties(studentVO, createdStudent);

		return createdStudent;

	}
	// for (StudentVo students : studentVoList) {
//         StudentBo studentBo = new StudentBo();
//         BeanUtils.copyProperties(students, studentBo);
//
//             EducationBo educationBo = new EducationBo();
//             educationBo.setStudent(students.getStu().getName());
//             studentBo.setEducation(educationBo);
//         }

	@Override
	public List<StudentBo> findAllStudent() {
		List<StudentBo> studentList = new ArrayList<>();

		List<StudentVo> studentVoList = studentrepository.findAll();
		if (null != studentVoList) {
			for (StudentVo student : studentVoList) {
				StudentBo studentBo = new StudentBo();
				 BeanUtils.copyProperties(student, studentBo);
				
//				  studentBo.setEducationDetails(student.getEducation().getEducationDetails());
//				  studentBo.setEducationId(student.getEducation().getEducationId());
//
//	            
				studentList.add(studentBo);

			}
			if (null != studentList) {
				return studentList;
			}
		}
		return null;
	}

		

	

	@Override
	public StudentBo getStudentById(int id) {
		StudentVo student = studentrepository.findById(id)
				.orElseThrow(() -> new RuntimeException(" Student not exist id: " + id));
		StudentBo studentBo = null;
		if (null != student && student.getId() > 0) {
			studentBo = new StudentBo();
//			 studentBo.setEducationDetails(student.getEducation().getEducationDetails());
//			  studentBo.setEducationId(student.getEducation().getEducationId());
			BeanUtils.copyProperties(student, studentBo);

		}
		return studentBo;
	}
	@Override
	public StudentBo updateStudent(StudentBo student) {
	    Optional<StudentVo> studentVoOptional = studentrepository.findById(student.getId());
	    if (studentVoOptional.isPresent()) {
	        StudentVo existingStudent = studentVoOptional.get();
	        
	        existingStudent.setName(student.getName());
	        existingStudent.setGender(student.getGender());
	        existingStudent.setEmail(student.getEmail());
	        existingStudent.setDateOfBirth(student.getDateOfBirth());
	        existingStudent.setPassword(student.getPassword());
	        existingStudent.setAddress(student.getAddress());
	        existingStudent.setCity(student.getCity());
	        existingStudent.setCountry(student.getCountry());
	        
//	        EducationVo education = existingStudent.getEducation();
//	        if (education != null) {
//	            education.setEducationDetails(student.getEducationDetails());
//	        }

	        studentrepository.save(existingStudent);

	        StudentBo updatedStudentBo = new StudentBo();
	        BeanUtils.copyProperties(existingStudent, updatedStudentBo);
	        return updatedStudentBo;
	    } else {
	        return null;
	    }
	}


//	@Override
//	public StudentBo updateStudent(StudentBo student) {
//		StudentVo studentVo = new StudentVo();
//        EducationVo education = studentVo.getEducation();
//
//		studentVo.setId(student.getId());
//		studentVo.setName(student.getName());
//		studentVo.setGender(student.getGender());
//		studentVo.setEmail(student.getEmail());
//		studentVo.setDateOfBirth(student.getDateOfBirth());
//		//studentVo.setMobileNUmber(student.getMobileNUmber());
//		studentVo.setPassword(student.getPassword());
//
//		studentVo.setAddress(student.getAddress());
//		studentVo.setCity(student.getCity());
//		studentVo.setCountry(student.getCountry());
//		education.setEducationDetails(student.getEducationDetails());
//		studentVo.add(education);
//		Optional<StudentVo> studentVoo =studentrepository.findById(student.getId());
//	if(studentVoo.isPresent()) {
//        StudentVo existingStudent = studentVoo.get();
//        BeanUtils.copyProperties(studentVo, existingStudent);
//        studentrepository.save(existingStudent);
//
//        StudentBo updatedStudentBo = new StudentBo();
//        BeanUtils.copyProperties(existingStudent, updatedStudentBo);
//        return updatedStudentBo;
//	}
//	return student;
//	}

	@Override
	public List<StudentBo> searchStudent(String name) {

		List<StudentBo> studentSearchList = new ArrayList<StudentBo>();
		List<StudentVo> studentVoList = studentrepository.searchByName(name);
		if (null != studentVoList) {
			for (StudentVo student : studentVoList) {

				StudentBo studentBo = new StudentBo();

				BeanUtils.copyProperties(student, studentBo);
				studentSearchList.add(studentBo);
			}
			return studentSearchList;

		}
		return studentSearchList;

	}

	@Override
	public int deleteStudentById(int id) {
		// TODO Auto-generated method stub
		studentrepository.deleteById(id);
		;
		return id;
	}
@Override
	  public StudentBo checkEmailExists(String email) {
	        StudentBo student = new StudentBo();
	        StudentVo studentVo = studentrepository.findByEmail(email);
	        if (studentVo != null) {
	            BeanUtils.copyProperties(studentVo, student);
	            return student;
	        }
	        return null;
}
	  @Override
		public StudentBo createEducation(EducationBo education, int id) {
			StudentVo studentVO = new StudentVo();
			EducationVo edu=new EducationVo();
			BeanUtils.copyProperties(education, edu);
			EducationVo educ=edurepository.save(edu);
			if(edu!=null) {
				studentVO=studentrepository.findById(id).get();
				//studentVO.setEducation(educ);
	 StudentVo student = studentrepository.save(studentVO);
		if(student!=null) {
			StudentBo std=new StudentBo();
			BeanUtils.copyProperties(student, std);

		
			return std;
		}
		}

			return null;

			
			
	  }

	@Override
	public LoginBo checkLogin(LoginBo login) {
		// TODO Auto-generated method stub
		LoginVo loginVo=new LoginVo();
		BeanUtils.copyProperties(login, loginVo);
		boolean loginVoo=loginRepository.loginCheck(loginVo);
		LoginBo result = new LoginBo();
	    BeanUtils.copyProperties(loginVo, result);
	    return result;
	}

	@Override
	public EducationBo createEducation(EducationBo education) {
		// TODO Auto-generated method stub
		EducationVo educationVo = new EducationVo();
		StudentVo student=new StudentVo();
		student.setId(education.getStudentBo().getId());
		educationVo.setStudent(student);
		
		BeanUtils.copyProperties(education, educationVo);
		educationVo = studentrepository.save(educationVo);
		EducationBo createdStudent = new EducationBo();
		StudentBo createdEdu=new StudentBo();
		BeanUtils.copyProperties(educationVo, createdStudent);

		return createdStudent;
	}

	@Override
	public List<EducationBo> findAllEducation() {
		List<EducationBo> educationList = new ArrayList<>();

		List<EducationVo> educationVoList = edurepository.findAll();
		if (null != educationVoList) {
			for (EducationVo education : educationVoList) {
				EducationBo educationBo = new EducationBo();
				 BeanUtils.copyProperties(education, educationBo);
				
//				  studentBo.setEducationDetails(student.getEducation().getEducationDetails());
//				  studentBo.setEducationId(student.getEducation().getEducationId());
//
//	            
				 educationList.add(educationBo);

			}
			if (null != educationList) {
				return educationList;
			}
		}
		return null;
	}

	@Override
	public EducationBo getEducationById(int educationId) {
		EducationVo education = edurepository.findById(educationId)
				.orElseThrow(() -> new RuntimeException(" Student not exist id: " + educationId));
		EducationBo educationBo = null;
		if (null != education && education.getEducationId() > 0) {
			educationBo = new EducationBo();
			  StudentVo studentVo = education.getStudent();
		        if (studentVo != null) {
		            StudentBo studentBo = new StudentBo();
		            studentBo.setRegisterId(studentVo.getRegisterId());
		            educationBo.setStudentBo(studentBo);

		        }

			BeanUtils.copyProperties(education, educationBo);

		}
		return educationBo;
	}

	@Override
	public EducationBo updateEducation(EducationBo education) {
		   Optional<EducationVo> studentVoOptional = edurepository.findById(education.getEducationId());
		    if (studentVoOptional.isPresent()) {
		    	EducationVo existingStudent = studentVoOptional.get();
		    	existingStudent.setEducationDetails(education.getEducationDetails());
		    	existingStudent.setEducationId(education.getEducationId());
		       

		        edurepository.save(existingStudent);

		        EducationBo updatedStudentBo = new EducationBo();
		        BeanUtils.copyProperties(existingStudent, updatedStudentBo);
		        return updatedStudentBo;
		    } else {
		        return null;
	}
}
//	@Override
//	public int deleteEducationById(int educationId) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

//	@Override
//	public void uploadImg(MultipartFile file) {
//	    try {
//	        ImageEntity imageEntity = new ImageEntity();
//	        imageEntity.setImage(file.getBytes());
//	        imageRepository.save(imageEntity);
//	    } catch (Exception e) {
//	        
//	        e.printStackTrace();
//	    }
//	}
	@Override
	@Transactional(rollbackFor = Exception.class) 
	public void uploadImg(MultipartFile file) {
	    try {
	        if (file.isEmpty()) {
	            throw new IllegalArgumentException("File is empty");
	        }

	        ImageEntity imageEntity = new ImageEntity();
	        imageEntity.setImage(file.getBytes()); 
	        imageRepository.save(imageEntity);
	    } catch (Exception e) {
	        
	       
	        e.printStackTrace();
	        
	    }
	}



}


