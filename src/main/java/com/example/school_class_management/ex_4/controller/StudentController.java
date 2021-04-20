package com.example.school_class_management.ex_4.controller;
import com.example.school_class_management.ex_4.dtos.GetStudentDTO;
import com.example.school_class_management.ex_4.dtos.RegisterStudentDTO;
import com.example.school_class_management.ex_4.service.StudentService;
import com.example.school_class_management.ex_4.utils.SuccessDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController


@RequestMapping("/student")
public class StudentController {

   private StudentService studentService;

   @Autowired
   public StudentController(StudentService studentService) {
      this.studentService = studentService;
   }



   @PostMapping("/register")
   @SneakyThrows
   public ResponseEntity<SuccessDto>registerStudent(@RequestBody RegisterStudentDTO registerStudentDTO)
   {
      studentService.registerStudent(registerStudentDTO);

      return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
   }

   @DeleteMapping()
   @SneakyThrows
   public ResponseEntity<SuccessDto>removeStudent(@RequestParam Long studentId)
   {
      studentService.removeStudent(studentId);

      return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
   }

   @DeleteMapping("/all")
   @SneakyThrows
   public ResponseEntity<SuccessDto>removeAllStudents()
   {
      studentService.removeAllStudents();

      return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
   }

   @GetMapping()
   @SneakyThrows
   public ResponseEntity<GetStudentDTO>getStudent(@RequestParam Long studentId)
   {

      return new ResponseEntity<>(studentService.getStudent(studentId), HttpStatus.OK);
   }


   @PutMapping()
   @SneakyThrows
   public ResponseEntity<SuccessDto>putStudent(@RequestParam Long studentId,@RequestBody RegisterStudentDTO registerStudentDTO)
   {
      studentService.putStudent(studentId,registerStudentDTO);

      return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
   }


}
