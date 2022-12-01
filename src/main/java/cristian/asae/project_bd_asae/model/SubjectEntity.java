package cristian.asae.project_bd_asae.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Subjects")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubject;
    @Column(length = 30, nullable = false)
    private String code;
    @Column(length = 30, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "idCourse",nullable = true)
    private CourseEntity objCourse;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Docent_Subject",
            joinColumns = @JoinColumn(name = "idSubject"),
            inverseJoinColumns = @JoinColumn(name = "id") )
    private List<DocentEntity> docents;
}
