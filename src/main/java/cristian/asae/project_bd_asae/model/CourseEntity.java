package cristian.asae.project_bd_asae.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;
    @Column(length = 30, nullable = true)
    private String period;
    @Column(length = 30, nullable = true)
    private String name;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objCourse")
    private List<SubjectEntity> subjects;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Student_Course",
            joinColumns = @JoinColumn(name = "idCourse"),
            inverseJoinColumns = @JoinColumn(name = "code"))
    private List<StudentEntity> students;

    public boolean addSubject(SubjectEntity subject){
        return this.subjects.add(subject);
    }
    public boolean addStudent(StudentEntity student){
        return this.students.add(student);
    }

}
