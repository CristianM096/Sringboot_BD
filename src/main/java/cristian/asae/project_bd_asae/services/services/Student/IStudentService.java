package cristian.asae.project_bd_asae.services.services.Student;

import java.util.List;

import cristian.asae.project_bd_asae.services.DTO.StudentDTO;

public interface IStudentService {
    public List<StudentDTO> findAll();

	public StudentDTO findById(Integer id);

	public StudentDTO save(StudentDTO student);

	public StudentDTO update(Integer id, StudentDTO student);

	public boolean delete(Integer id);
}
