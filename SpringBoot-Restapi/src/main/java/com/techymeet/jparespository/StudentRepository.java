package com.techymeet.jparespository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.techymeet.bo.EducationBo;
import com.techymeet.bo.StudentBo;
import com.techymeet.vo.EducationVo;
import com.techymeet.vo.StudentVo;


public interface StudentRepository extends JpaRepository<StudentVo,Integer > {

	StudentVo save(StudentVo studentVO);

	List<StudentVo> searchByName(String name);


	//StudentBo getStudentByEmail(String email);


	StudentVo findByEmail(String email);


	EducationVo save(EducationVo educationVO);

	
	
	
}
