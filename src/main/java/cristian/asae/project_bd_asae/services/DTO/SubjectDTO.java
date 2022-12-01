package cristian.asae.project_bd_asae.services.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class SubjectDTO {
    private Integer idSubject;
    private String code;
    private String name;

    private CourseDTO objCourse;
    private List<DocentDTO> docents;
}
