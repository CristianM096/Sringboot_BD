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

import cristian.asae.project_bd_asae.services.DTO.DocentDTO;
import cristian.asae.project_bd_asae.services.services.Docent.IDocentService;


@RestController
@RequestMapping("/api")
public class DocentRestController {
    
    @Autowired
    private IDocentService docentService;

    @GetMapping("/Docents")
    public List<DocentDTO> index() {
        return docentService.findAll();
    }

    @GetMapping("/Docents/{id}")
    public DocentDTO show(@PathVariable Integer id) {
        return docentService.findById(id);
    }

    @PostMapping("/Docents")
	public DocentDTO create(@RequestBody DocentDTO docent) {
		DocentDTO objDocent = null;
		objDocent = docentService.save(docent);
		return objDocent;
	}
    
    @PutMapping(value="/Docents/{id}")
    public DocentDTO update(@PathVariable Integer id, @RequestBody DocentDTO docent) {
        DocentDTO objDocent = null;
        DocentDTO docentCurrent = docentService.findById(id);
        if(docentCurrent != null){
            objDocent = docentService.update(id,docent);
        }
        return objDocent;
    }

    @DeleteMapping("/Docents/{id}")
    public boolean delete(@PathVariable Integer id){
        boolean answer = false;
        DocentDTO docentCurrent = docentService.findById(id);
        if(docentCurrent != null){
            answer = docentService.delete(id);
        }
        return answer;
    }
}
