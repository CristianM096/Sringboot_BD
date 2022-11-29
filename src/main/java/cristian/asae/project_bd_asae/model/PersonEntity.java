package cristian.asae.project_bd_asae.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public class PersonEntity {
    @Id
    @Column(length = 10)
    private Integer id;
    @Column(length = 30, nullable = false)
    private String dniType;
    @Column(length = 30, nullable = false)
    private String dni;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String lastname;
}
