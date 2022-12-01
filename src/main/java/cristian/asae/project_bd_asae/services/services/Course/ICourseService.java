package cristian.asae.project_bd_asae.services.services.Course;

import java.util.List;

import cristian.asae.project_bd_asae.services.DTO.CourseDTO;


public interface ICourseService {
    public List<CourseDTO> findAll();

	public CourseDTO findById(Integer id);

	public CourseDTO save(CourseDTO course);

	public CourseDTO update(Integer id, CourseDTO course);

	public boolean delete(Integer id);
}
