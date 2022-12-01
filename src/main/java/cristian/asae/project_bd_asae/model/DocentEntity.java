package cristian.asae.project_bd_asae.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Docents")
public class DocentEntity extends PersonEntity{
    @Column(length = 30,nullable = true)
    private String university;
    @Column(length = 30,nullable = false)
    private String typeDocent;
    @Column(nullable = false)
    private float salary;
}
