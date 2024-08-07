package com.techymeet.jparespository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.techymeet.bo.EducationBo;
import com.techymeet.vo.EducationVo;
import com.techymeet.vo.StudentVo;

public interface EducationResository extends JpaRepository<EducationVo,Integer >  {

	EducationVo save(StudentVo studentVO);

	Optional<StudentVo> findByEducationId(int educationId);


}
