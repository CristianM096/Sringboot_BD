package cristian.asae.project_bd_asae.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cristian.asae.project_bd_asae.services.DTO.CourseDTO;
import cristian.asae.project_bd_asae.services.services.Course.ICourseService;



@RestController
@RequestMapping("/api")
public class CourseRestController {
    
    @Autowired
    private ICourseService courseService;

    @GetMapping("/Courses")
    public List<CourseDTO> index() {
        return courseService.findAll();
    }

    @GetMapping("/Courses/{id}")
    public CourseDTO show(@PathVariable Integer id) {
        return courseService.findById(id);
    }

    @PostMapping("/Courses")
	public CourseDTO create(@RequestBody CourseDTO course) {
		CourseDTO objCourse = null;
		objCourse = courseService.save(course);
		return objCourse;
	}
    
    @PutMapping(value="/Courses/{id}")
    public CourseDTO update(@PathVariable Integer id, @RequestBody CourseDTO course) {
        CourseDTO objCourse = null;
        CourseDTO courseCurrent = courseService.findById(id);
        if(courseCurrent != null){
            objCourse = courseService.update(id,course);
        }
        return objCourse;
    }

    @PostMapping(value = "/Courses/{id}&&{idStudent}")
    public CourseDTO enrollStudent(@PathVariable Integer id,@PathVariable Integer idStudent) {
        CourseDTO objCourse = null;
        CourseDTO courseCurrent = courseService.findById(id);
        if(courseCurrent != null){
            objCourse = courseService.enrollStudent(idStudent, id);
        }
        return objCourse;
    }

    @DeleteMapping("/Courses/{id}")
    public boolean delete(@PathVariable Integer id){
        boolean answer = false;
        CourseDTO courseCurrent = courseService.findById(id);
        if(courseCurrent != null){
            answer = courseService.delete(id);
        }
        return answer;
    }
}
