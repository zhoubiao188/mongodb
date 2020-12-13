package cn.ityoudream.controller;

import cn.ityoudream.dto.StudentEntityDTO;
import cn.ityoudream.entity.StudentEntity;
import cn.ityoudream.repository.StudentRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@Api(tags = "Student InferFace")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @ApiOperation("addStudent")
    @PostMapping
    public ResponseEntity<StudentEntityDTO> addStudent(@RequestBody StudentEntityDTO studentEntityDTO) {
        Assert.notNull(studentEntityDTO, "×Ö¶Î²»ÄÜÎª¿Õ");
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(studentEntityDTO, studentEntity);
        StudentEntity save = studentRepository.save(studentEntity);
        System.out.println("save:" + save);
        return new ResponseEntity<StudentEntityDTO>(HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("findAll")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<Object>(studentRepository.findAll(),HttpStatus.OK);

    }
}
