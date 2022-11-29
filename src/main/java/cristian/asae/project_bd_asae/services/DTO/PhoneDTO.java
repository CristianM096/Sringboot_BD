package cristian.asae.project_bd_asae.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PhoneDTO {
    private Integer idPhone;
    private String type;
    private String number;

    private StudentDTO objStudent;
}
