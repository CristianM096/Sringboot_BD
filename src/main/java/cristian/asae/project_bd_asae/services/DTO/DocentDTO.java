package cristian.asae.project_bd_asae.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class DocentDTO {
    private String university;
    private String typeDocent;
    private float salary;
}
