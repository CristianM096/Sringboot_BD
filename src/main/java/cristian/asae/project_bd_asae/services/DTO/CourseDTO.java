package cristian.asae.project_bd_asae.services.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CourseDTO {
    private Integer idCourse;
    private String period;
    private String name;
    
    private List<SubjectDTO> subjects;
    private List<StudentDTO> students;

}
