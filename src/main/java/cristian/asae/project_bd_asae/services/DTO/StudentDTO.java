package cristian.asae.project_bd_asae.services.DTO;

import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class StudentDTO{
    
    private Date dateEntry;

    private AddressDTO objAddress;
    
    private List<PhoneDTO> phones;
}
