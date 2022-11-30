package cristian.asae.project_bd_asae.services.services.Student;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cristian.asae.project_bd_asae.model.AddressEntity;
import cristian.asae.project_bd_asae.model.StudentEntity;
import cristian.asae.project_bd_asae.repository.StudentRepository;
import cristian.asae.project_bd_asae.services.DTO.StudentDTO;

@Service
public class StudentServiceImp implements IStudentService{

    @Autowired
	private StudentRepository servicioAccesoBaseDatos;

	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> findAll() {
		Iterable<StudentEntity> studentsEntity = this.servicioAccesoBaseDatos.findAll();
		System.out.println("antes de la consulta");
		List<StudentDTO> studentsDTO = this.modelMapper.map(studentsEntity, new TypeToken<List<StudentDTO>>() {}.getType());
		return studentsDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDTO findById(Integer id) {
		Optional<StudentEntity> studentsEntity = this.servicioAccesoBaseDatos.findById(id);
		System.out.println("antes de la consulta");
		StudentDTO studentsDTO = this.modelMapper.map(studentsEntity.get(), new TypeToken<StudentDTO>() {}.getType());
		return studentsDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public StudentDTO save(StudentDTO student) {
        StudentEntity studentEntity = this.modelMapper.map(student, StudentEntity.class);
        if(studentEntity.getObjAddress() != null){
            studentEntity.getObjAddress().setObjStudent(studentEntity);
        }
        if(studentEntity.getPhones() != null){
            studentEntity.getPhones().forEach(phone->phone.setObjStudent(studentEntity));
        }
        StudentEntity studentEntitySaved = this.servicioAccesoBaseDatos.save(studentEntity);
        StudentDTO studentDTO = this.modelMapper.map(studentEntitySaved, StudentDTO.class);
        return studentDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public StudentDTO update(Integer id, StudentDTO student) {
        Optional<StudentEntity> studentOptional  = this.servicioAccesoBaseDatos.findById(id);
        StudentDTO studentDTOUpdate = null;
        StudentEntity studentEntity = studentOptional.get();
        if(studentEntity != null){
            studentEntity.setDni(student.getDni());
            studentEntity.setDateEntry(student.getDateEntry());
            studentEntity.setDniType(student.getDniType());
            studentEntity.setId(student.getId());
            studentEntity.setLastname(student.getLastname());
            studentEntity.setName(student.getName());
            /* Update Address */
            AddressEntity addressEntity = studentEntity.getObjAddress();
            addressEntity.setCity(student.getObjAddress().getCity());
            addressEntity.setCountry(student.getObjAddress().getCountry());
            addressEntity.setResidenceAddress(student.getObjAddress().getResidenceAddress());
            /* Update Phones */
            studentEntity.getPhones().forEach(phone -> {
                student.getPhones().forEach(phoneUpdate -> {
                    if(phone.getIdPhone() == phoneUpdate.getIdPhone()){
                        phone.setNumber(phoneUpdate.getNumber());
                        phone.setType(phoneUpdate.getType());
                    }
                });
            });

            /* Save Student */
            StudentEntity studentEntityUpdate = this.servicioAccesoBaseDatos.save(studentEntity);
            studentDTOUpdate = this.modelMapper.map(studentEntityUpdate, StudentDTO.class);
        }
        return studentDTOUpdate;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Integer id) {
        boolean request = false;
        Optional<StudentEntity> studentOptional = this.servicioAccesoBaseDatos.findById(id);
        StudentEntity studentEntity = studentOptional.get();
        if(studentEntity != null){
            this.servicioAccesoBaseDatos.delete(studentEntity);
            request = true;
        }
        return request;
    }
    
}
