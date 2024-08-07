package com.techymeet.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.techymeet.bo.EducationBo;
import com.techymeet.bo.LoginBo;
import com.techymeet.bo.StudentBo;
import com.techymeet.jparespository.ImageRepository;
import com.techymeet.jparespository.StudentRepository;
import com.techymeet.service.StudentService;
import com.techymeet.vo.ImageEntity;

import lombok.extern.log4j.Log4j2;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/crud")
@Log4j2
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentRepository studentrepository;
	@Autowired
	private ImageRepository imageRepository;

	
	@PostMapping(path="/login")
	public ResponseEntity<LoginBo> checkLogin(@RequestBody LoginBo login){
		log.info("Splunk initiated");

		login=studentService.checkLogin(login);
		return new ResponseEntity<LoginBo>(login,HttpStatus.OK);
	}
	@PostMapping(path="/student")
	public ResponseEntity<StudentBo> createStudent(@RequestBody StudentBo student){
		log.info("Splunk initiated");
//		 try {
//			  byte[] imageData = file.getBytes();
//			  
//			  student.setImage(imageData);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		student=studentService.createStudent(student);
		// student=studentrepository.save(student);
		
		return new ResponseEntity<StudentBo>(student,HttpStatus.OK);
		
	}
	@GetMapping(path="/student")
	public ResponseEntity<List<StudentBo>> findAllStudents(){
		
		log.info("Splunk initiated");
		log.error("splink exception");
		List<StudentBo> studentList=null;
		try {
		studentList=studentService.findAllStudent();
		
		}catch(Exception e) {
			e.printStackTrace()	;
			log.error("Error");
			}
		return new ResponseEntity<List<StudentBo>>(studentList,HttpStatus.OK);
	}
	@GetMapping(path="/student/list")
	public ResponseEntity<List<EducationBo>> findAllEducation(){
		List<EducationBo> educationList=studentService.findAllEducation();
		return new ResponseEntity<List<EducationBo>>(educationList,HttpStatus.OK);

	}
	@GetMapping(path="/student/{id}")
	public ResponseEntity<StudentBo> getStudentById(@PathVariable("id") int id) {
		log.info("Splunk initiated");
		log.error("splink exception");
		 StudentBo student =null;
	    try { student = studentService.getStudentById(id);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	log.error("error");
	    }
	    return new ResponseEntity<StudentBo>(student, HttpStatus.OK);
	}

	
	@PutMapping(path="/student/{id}")
	   public ResponseEntity<StudentBo> updateStudent(@RequestBody StudentBo student,@PathVariable("id") int id) {
		 student=studentService.updateStudent(student);
		 return new ResponseEntity<StudentBo>(student,HttpStatus.OK);
	}
	@GetMapping(path="/search/{name}")
	public ResponseEntity<List<StudentBo>> searchByStudentName(@PathVariable String name) {
		List<StudentBo> student=studentService.searchStudent(name);
		return new ResponseEntity<List<StudentBo>>(student,HttpStatus.OK);	
	}
	@DeleteMapping(path="/student/{id}")
	public ResponseEntity<Integer> deleteStudent(@PathVariable int id){
		int rollNo=studentService.deleteStudentById(id);
		 return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
	 @GetMapping(path="/student/update/{email}")
	    public ResponseEntity<Boolean> getStudentByEmail(@PathVariable String email) {
	        StudentBo student = studentService.checkEmailExists(email);
	        if(student != null) {
	            return ResponseEntity.ok(true);
	        }
	        return ResponseEntity.ok(false);
	    }
	 
//	 @PostMapping(path="/education/{id}")
//	 public ResponseEntity<Boolean> createEducation(@RequestBody EducationBo education, @PathVariable("id") int id){
//		 StudentBo std=null;
//		 
//		 std=studentService.createEducation(education,id);
//			
//			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
//			
//		}
	 @PostMapping(path="/education")
	 public ResponseEntity<Boolean> createEducation(@RequestBody EducationBo education){
		 EducationBo std=null;
		
		 std=studentService.createEducation(education);
			
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			
		}
	 @GetMapping(path="/education/{educationId}")
	 public ResponseEntity<EducationBo> viewEducation(@PathVariable ("educationId") int educationId){
		 EducationBo education=studentService.getEducationById(educationId);
		    return new ResponseEntity<EducationBo>(education, HttpStatus.OK);

	 }
	 @PutMapping(path="updateeducation/{educationId}")
	 public ResponseEntity<EducationBo> updateEducation(@RequestBody EducationBo education, @PathVariable ("educationId") int educationId){
		 education=studentService.updateEducation(education);
		 return new ResponseEntity<EducationBo>(education,HttpStatus.OK);
	 }
	 @DeleteMapping(path="/deleteEducation/{educationId}")
		public ResponseEntity<Integer> deleteEducation(@PathVariable("educationId") int educationId){
			//int rollNo=studentService.deleteEducationById(educationId);
			 return new ResponseEntity<Integer>(educationId,HttpStatus.OK);
		}
	 @GetMapping(path="/registerId")
	 public ResponseEntity<List<StudentBo>> retrieveId(){
		List< StudentBo> student=studentService.findAllStudent();
		return new ResponseEntity<List<StudentBo>>(student, HttpStatus.OK);
	 }
//	 @PostMapping(path="/import")
//	 public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file ){
//		 EducationBo stu=studentService.uploadImg(file);
//		 
//		return new ResponseEntity<StudentBo>();
//		 
//		 
//	 }
	 
	 @PostMapping("/import")
	 public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
	     try {
	         studentService.uploadImg(file);
	         return ResponseEntity.ok().body("File uploaded successfully");
	         } catch (Exception e) {
	         e.printStackTrace(); 
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
	     }
	 }
	 @GetMapping("/getImage/{id}")
	    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
	        ImageEntity image = imageRepository.findById(id).orElse(null);
	        if (image != null) {
	            return ResponseEntity.ok().body(image.getImage());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    @GetMapping(path = { "/get/{id}" })
		public ImageEntity getImage(@PathVariable("id") long imageId) throws IOException {
	    	final Optional<ImageEntity> retrievedImage = imageRepository.findById(imageId);
	    	ImageEntity img = new ImageEntity(retrievedImage.get().getName(), retrievedImage.get().getType(),
					decompressBytes(retrievedImage.get().getImage()));
			return img;
		}
	    public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
	 }
