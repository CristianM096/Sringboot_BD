package cristian.asae.project_bd_asae.model;

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
    private String university;
    private String typeDocent;
    private float salary;
}
