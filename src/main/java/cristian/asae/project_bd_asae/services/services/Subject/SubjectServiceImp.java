package cristian.asae.project_bd_asae.services.services.Subject;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cristian.asae.project_bd_asae.model.CourseEntity;
import cristian.asae.project_bd_asae.model.DocentEntity;
import cristian.asae.project_bd_asae.model.SubjectEntity;
import cristian.asae.project_bd_asae.repository.CourseRepository;
import cristian.asae.project_bd_asae.repository.SubjectRepository;
import cristian.asae.project_bd_asae.services.DTO.CourseDTO;
import cristian.asae.project_bd_asae.services.DTO.SubjectDTO;



@Service
public class SubjectServiceImp implements ISubjectService{

    @Autowired
	private SubjectRepository servicioAccesoBaseDatos;

    @Autowired
    private CourseRepository servicioCourseAccesoBaseDatos;

	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SubjectDTO> findAll() {
		Iterable<SubjectEntity> subjectsEntity = this.servicioAccesoBaseDatos.findAll();
		System.out.println("antes de la consulta");
		List<SubjectDTO> subjectsDTO = this.modelMapper.map(subjectsEntity, new TypeToken<List<SubjectDTO>>() {}.getType());
		return subjectsDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public SubjectDTO findById(Integer id) {
		Optional<SubjectEntity> subjectEntity = this.servicioAccesoBaseDatos.findById(id);
		System.out.println("antes de la consulta");
		SubjectDTO subjectDTO = this.modelMapper.map(subjectEntity.get(), new TypeToken<SubjectDTO>() {}.getType());
		return subjectDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public SubjectDTO save(SubjectDTO subject) {
        SubjectEntity subjectEntity = this.modelMapper.map(subject, SubjectEntity.class);
        // CourseEntity courseEntity = this.servicioCourseAccesoBaseDatos.findById(subjectEntity.getObjCourse().getIdCourse()).get();
        // courseEntity.addSubject(subjectEntity);
        List<DocentEntity> docents = subjectEntity.getDocents();
        CourseEntity courseEntity = subjectEntity.getObjCourse();
        SubjectDTO subjectDTO = null;
        if(courseEntity != null && docents.size() > 1){
            servicioCourseAccesoBaseDatos.findById(courseEntity.getIdCourse()).get().addSubject(subjectEntity);
            SubjectEntity subjectEntitySaved = this.servicioAccesoBaseDatos.save(subjectEntity);
            subjectDTO = this.modelMapper.map(subjectEntitySaved, SubjectDTO.class);
        }
        return subjectDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public SubjectDTO update(Integer id, SubjectDTO subject) {
        Optional<SubjectEntity> subjectOptional  = this.servicioAccesoBaseDatos.findById(id);
        SubjectDTO subjectDTOUpdate = null;
        SubjectEntity subjectEntity = subjectOptional.get();
        if(subjectEntity != null){
            subjectEntity.setIdSubject(subject.getIdSubject());
            subjectEntity.setName(subject.getName());
            subjectEntity.setCode(subject.getCode());
            /* Save Subject */
            SubjectEntity subjectEntityUpdate = this.servicioAccesoBaseDatos.save(subjectEntity);
            subjectDTOUpdate = this.modelMapper.map(subjectEntityUpdate, SubjectDTO.class);
        }
        return subjectDTOUpdate;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Integer id) {
        boolean request = false;
        Optional<SubjectEntity> subjectOptional = this.servicioAccesoBaseDatos.findById(id);
        SubjectEntity subjectEntity = subjectOptional.get();
        if(subjectEntity != null){
            this.servicioAccesoBaseDatos.delete(subjectEntity);
            request = true;
        }
        return request;
    }
    
}
