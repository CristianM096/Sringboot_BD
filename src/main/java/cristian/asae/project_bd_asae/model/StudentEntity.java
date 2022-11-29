package cristian.asae.project_bd_asae.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Students")
public class StudentEntity extends PersonEntity{
    
    private Date dateEntry;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "objStudent")
    private AddressEntity objAddress;

}
