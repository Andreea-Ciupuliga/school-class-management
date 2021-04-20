package com.example.school_class_management.ex_4.controller;
import com.example.school_class_management.ex_4.dtos.GetProfesorDTO;
import com.example.school_class_management.ex_4.dtos.RegisterProfesorDTO;
import com.example.school_class_management.ex_4.service.ProfesorService;
import com.example.school_class_management.ex_4.utils.SuccessDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    private ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }


    @PostMapping("/register")
    @SneakyThrows
    public ResponseEntity<SuccessDto> registerProfesor(@RequestBody RegisterProfesorDTO registerProfesorDTO)
    {
        profesorService.registerProfesor(registerProfesorDTO);

        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }


    @PutMapping()
    @SneakyThrows
    public ResponseEntity<SuccessDto>putProfesor(@RequestParam Long profesorId,@RequestBody RegisterProfesorDTO registerProfesorDTO)
    {
        profesorService.putProfesor(profesorId,registerProfesorDTO);

        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }


    @DeleteMapping()
    @SneakyThrows
    public ResponseEntity<SuccessDto>removeProfesor(@RequestParam Long profesorId)
    {
        profesorService.removeProfesor(profesorId);

        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }

    @DeleteMapping("/all")
    @SneakyThrows
    public ResponseEntity<SuccessDto>removeAllProfesors()
    {
        profesorService.removeAllProfesors();
        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }

    @GetMapping()
    @SneakyThrows
    public ResponseEntity<GetProfesorDTO>getProfesor(@RequestParam Long profesorId)
    {

        return new ResponseEntity<>(profesorService.getProfesor(profesorId), HttpStatus.OK);
    }


}
