package cristian.asae.project_bd_asae;

import java.util.LinkedList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cristian.asae.project_bd_asae.model.Address;
import cristian.asae.project_bd_asae.model.Course;
import cristian.asae.project_bd_asae.model.Student;
import cristian.asae.project_bd_asae.model.Subject;
import cristian.asae.project_bd_asae.service.repository.CourseRepository;
import cristian.asae.project_bd_asae.service.repository.StudentRepository;
import cristian.asae.project_bd_asae.service.repository.SubjectRepository;
import java.util.Scanner;

@SpringBootApplication
@Transactional
public class ProjectBdAsaeApplication implements CommandLineRunner{
	@Autowired
	private StudentRepository servicioStudentAccesoBD;
	@Autowired
	private SubjectRepository servicioSubjectAccesoBD;
	@Autowired
	private CourseRepository servicioCourseAccesoBD;
	private Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(ProjectBdAsaeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		scanner.nextLine();
		saveStudentAddress();
		scanner.nextLine();
		saveCourseSubject();
		scanner.nextLine();
		enrollStudentinCourse("1", 1);
		scanner.nextLine();
		getCourseWithStudent();
	}


	private void saveStudentAddress(){
		/**Create student */
		Student student = new Student();
		student.setCode("1");
		student.setDniType("CC");
		student.setDni("123");
		student.setName("PEPITO");
		student.setLastname("PEREZ");
		/**Create Address */
		Address address = new Address();
		address.setResidenceAddress("calle1");
		address.setCity("popayán");
		address.setCountry("Colombia");
		address.setObjStudent(student);
		/**Assign address to student */
		student.setObjAddress(address);
		/**Save Student and Address by Cascade Persistence */
		servicioStudentAccesoBD.save(student);
	}

	private void saveCourseSubject(){
		/**Create Course */
		Course curso = new Course();
		curso.setPeriod("1");
		curso.setGroupe("1");
		curso.setSubjects(new LinkedList<>());
		curso.setStudents(new LinkedList<>());
		/**Create Subject */
		Subject subject = new Subject();
		subject.setCode("1");
		subject.setName("Matemáticas");
		subject.setObjCourse(curso);
		/**Assign subject in course */
		curso.addSubject(subject);
		/**Save Course */
		servicioCourseAccesoBD.save(curso);
		/**Save Subject */
		servicioSubjectAccesoBD.save(subject);
	}

	private void enrollStudentinCourse(String idStudent, Integer idCourse){
		Optional<Student> foundStudent = this.servicioStudentAccesoBD.findById(idStudent);
		Optional<Course> foundCourse = this.servicioCourseAccesoBD.findById(idCourse);

		if(foundStudent.isPresent() && foundCourse.isPresent()){
			Student student = foundStudent.get();
			Course course = foundCourse.get();
			course.addStudent(student);
			this.servicioStudentAccesoBD.save(student);
		}else{
			System.out.println("No se pudo matricular, el estudiante o el curso no existen");
		}
	}


	private void getCourseWithStudent(){
		Iterable<Course> courses = this.servicioCourseAccesoBD.findAll();
		for (Course course : courses) {
			Iterable<Student> students = course.getStudents();
			Iterable<Subject> subjects = course.getSubjects();
			System.out.println("Asignaturas: ");
			for (Subject subject : subjects) {
				System.out.println(subject.getName()+" "+subject.getCode());
			}
			System.out.println("Estudiantes: ");
			for (Student student : students) {
				System.out.println(student.getName());
			}
		}
	}
}
