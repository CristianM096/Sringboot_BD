package cristian.asae.project_bd_asae.controller;


import java.util.List;

import javax.print.attribute.standard.NumberUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.spi.STEUtil;
import cristian.asae.project_bd_asae.services.DTO.StudentDTO;
import cristian.asae.project_bd_asae.services.services.Student.IStudentService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class StudentRestController {
    
    @Autowired
    private IStudentService studentService;

    @GetMapping("/Students")
    public List<StudentDTO> index() {
        List<StudentDTO> list = studentService.findAll();
        return list;
        // return studentService.findAll();
    }

    @GetMapping("/Students/{id}")
    public StudentDTO show(@PathVariable Integer id) {
        return studentService.findById(id);
    }

    @PostMapping("/Students")
	public StudentDTO create(@RequestBody StudentDTO student) {
		StudentDTO objStudent = null;
		objStudent = studentService.save(student);
		return objStudent;
	}
    
    @PutMapping(value="/Students/{id}")
    public StudentDTO update(@PathVariable Integer id, @RequestBody StudentDTO student) {
        StudentDTO objStudent = null;
        StudentDTO studentCurrent = studentService.findById(id);
        if(studentCurrent != null){
            objStudent = studentService.update(id,student);
        }
        return objStudent;
    }

    @DeleteMapping("/Students/{id}")
    public boolean delete(@PathVariable Integer id){
        boolean answer = false;
        StudentDTO studentCurrent = studentService.findById(id);
        if(studentCurrent != null){
            answer = studentService.delete(id);
        }
        return answer;
    }
}
