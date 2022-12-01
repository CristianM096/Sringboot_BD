package cristian.asae.project_bd_asae.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AddressDTO {
    private Integer idAddress;
    private String residenceAddress;
    private String city;
    private String country;
}
