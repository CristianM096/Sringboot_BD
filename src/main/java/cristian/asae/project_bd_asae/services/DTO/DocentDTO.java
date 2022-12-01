package cristian.asae.project_bd_asae.services.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class DocentDTO {
    private Integer id;
    private String dniType;
    private String dni;
    private String name;
    private String lastname;
    private String university;
    private String typeDocent;
    private float salary;
}
