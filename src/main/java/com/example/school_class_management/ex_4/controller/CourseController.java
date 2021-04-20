package com.example.school_class_management.ex_4.controller;
import com.example.school_class_management.ex_4.dtos.GetCourseDTO;
import com.example.school_class_management.ex_4.dtos.RegisterCourseDTO;
import com.example.school_class_management.ex_4.service.CourseService;
import com.example.school_class_management.ex_4.utils.SuccessDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/register")
    @SneakyThrows
    public ResponseEntity<SuccessDto> registerCourse(@RequestBody RegisterCourseDTO registerCourseDTO)
    {
        courseService.registerCourse(registerCourseDTO);

        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }

    @DeleteMapping
    @SneakyThrows
    public ResponseEntity<SuccessDto> removeCourse(@RequestParam Long courseId)
    {
        courseService.removeCourse(courseId);

        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }

    @DeleteMapping("/all")
    @SneakyThrows
    public ResponseEntity<SuccessDto> removeAllCourses()
    {
        courseService.removeAllCourses();

        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }


    @GetMapping()
    @SneakyThrows
    public ResponseEntity<GetCourseDTO> getCourse(@RequestParam Long courseId)
    {
        return new ResponseEntity<>(courseService.getCourse(courseId), HttpStatus.OK);
    }

    @PutMapping()
    @SneakyThrows
    public ResponseEntity<SuccessDto> putCourses(@RequestParam Long courseId,@RequestBody RegisterCourseDTO registerCourseDTO)
    {
        courseService.putCourse(courseId,registerCourseDTO);

        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }

}
