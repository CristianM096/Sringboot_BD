package cristian.asae.project_bd_asae.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Phones")
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPhone;
    @Column(length = 20, nullable = false)
    private String type;
    @Column(length = 20, nullable = false)
    private String number;

    @ManyToOne( cascade = {CascadeType.ALL})
    @JoinColumn(name = "idStudent",nullable = false)
    private StudentEntity objStudent;
}
