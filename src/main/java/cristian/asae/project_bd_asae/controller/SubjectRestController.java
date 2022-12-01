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

import cristian.asae.project_bd_asae.services.DTO.SubjectDTO;
import cristian.asae.project_bd_asae.services.services.Subject.ISubjectService;

@RestController
@RequestMapping("/api")
public class SubjectRestController {
    
    @Autowired
    private ISubjectService subjectService;

    @GetMapping("/Subjects")
    public List<SubjectDTO> index() {
        return subjectService.findAll();
    }

    @GetMapping("/Subjects/{id}")
    public SubjectDTO show(@PathVariable Integer id) {
        return subjectService.findById(id);
    }

    @PostMapping("/Subjects")
	public SubjectDTO create(@RequestBody SubjectDTO subject) {
		SubjectDTO objSubject = null;
		objSubject = subjectService.save(subject);
		return objSubject;
	}
    
    @PutMapping(value="/Subjects/{id}")
    public SubjectDTO update(@PathVariable Integer id, @RequestBody SubjectDTO subject) {
        SubjectDTO objSubject = null;
        SubjectDTO subjectCurrent = subjectService.findById(id);
        if(subjectCurrent != null){
            objSubject = subjectService.update(id,subject);
        }
        return objSubject;
    }

    @DeleteMapping("/Subjects/{id}")
    public boolean delete(@PathVariable Integer id){
        boolean answer = false;
        SubjectDTO subjectCurrent = subjectService.findById(id);
        if(subjectCurrent != null){
            answer = subjectService.delete(id);
        }
        return answer;
    }
}
