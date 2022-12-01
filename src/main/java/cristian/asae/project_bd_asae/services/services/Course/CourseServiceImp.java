package cristian.asae.project_bd_asae.services.services.Course;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cristian.asae.project_bd_asae.model.CourseEntity;
import cristian.asae.project_bd_asae.model.StudentEntity;
import cristian.asae.project_bd_asae.repository.CourseRepository;
import cristian.asae.project_bd_asae.repository.StudentRepository;
import cristian.asae.project_bd_asae.services.DTO.CourseDTO;
import cristian.asae.project_bd_asae.services.DTO.StudentDTO;


@Service
public class CourseServiceImp implements ICourseService{

    @Autowired
	private CourseRepository servicioAccesoBaseDatos;

    @Autowired
    private StudentRepository servicioStudentAccesoBaseDatos;

	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CourseDTO> findAll() {
		Iterable<CourseEntity> coursesEntity = this.servicioAccesoBaseDatos.findAll();
		System.out.println("antes de la consulta");
		List<CourseDTO> coursesDTO = this.modelMapper.map(coursesEntity, new TypeToken<List<CourseDTO>>() {}.getType());
		return coursesDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public CourseDTO findById(Integer id) {
		Optional<CourseEntity> courseEntity = this.servicioAccesoBaseDatos.findById(id);
		System.out.println("antes de la consulta");
		CourseDTO courseDTO = this.modelMapper.map(courseEntity.get(), new TypeToken<CourseDTO>() {}.getType());
		return courseDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public CourseDTO save(CourseDTO course) {
        CourseEntity courseEntity = this.modelMapper.map(course, CourseEntity.class);
        CourseEntity courseEntitySaved = this.servicioAccesoBaseDatos.save(courseEntity);
        CourseDTO courseDTO = this.modelMapper.map(courseEntitySaved, CourseDTO.class);
        return courseDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public CourseDTO update(Integer id, CourseDTO course) {
        Optional<CourseEntity> courseOptional  = this.servicioAccesoBaseDatos.findById(id);
        CourseDTO courseDTOUpdate = null;
        CourseEntity courseEntity = courseOptional.get();
        if(courseEntity != null){
            courseEntity.setIdCourse(course.getIdCourse());
            courseEntity.setName(course.getName());
            courseEntity.setPeriod(course.getPeriod());
            /* Save Course */
            CourseEntity courseEntityUpdate = this.servicioAccesoBaseDatos.save(courseEntity);
            courseDTOUpdate = this.modelMapper.map(courseEntityUpdate, CourseDTO.class);
        }
        return courseDTOUpdate;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Integer id) {
        boolean request = false;
        Optional<CourseEntity> courseOptional = this.servicioAccesoBaseDatos.findById(id);
        CourseEntity courseEntity = courseOptional.get();
        if(courseEntity != null){
            this.servicioAccesoBaseDatos.delete(courseEntity);
            request = true;
        }
        return request;
    }

    @Override
    @Transactional(readOnly = false)
    public CourseDTO enrollStudent(Integer idStudent, Integer idCourse) {
        CourseEntity courseEntity = this.servicioAccesoBaseDatos.findById(idCourse).get();
        StudentEntity studentEntity = this.servicioStudentAccesoBaseDatos.findById(idStudent).get();
        CourseDTO courseDTO = null;
        if(courseEntity != null && studentEntity != null){
            courseEntity.addStudent(studentEntity);
            CourseEntity courseEntityUpdate = this.servicioAccesoBaseDatos.save(courseEntity);
            courseDTO = this.modelMapper.map(courseEntityUpdate, CourseDTO.class);
        }
        return courseDTO;
    }
    
}
