package cristian.asae.project_bd_asae.services.services.Subject;

import java.util.List;

import cristian.asae.project_bd_asae.services.DTO.SubjectDTO;

public interface ISubjectService {
    public List<SubjectDTO> findAll();

	public SubjectDTO findById(Integer id);

	public SubjectDTO save(SubjectDTO subject);

	public SubjectDTO update(Integer id, SubjectDTO subject);

	public boolean delete(Integer id);
}
