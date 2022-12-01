package cristian.asae.project_bd_asae.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;
    @Column(length = 30,nullable = false)
    private String residenceAddress;
    @Column(length = 30, nullable = false)
    private String city;
    @Column(length = 30, nullable = false)
    private String country;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "idStudent", nullable = false)
    private StudentEntity objStudent;
}
