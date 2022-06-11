package peaksoft.repositories;

import org.springframework.stereotype.Repository;
import peaksoft.models.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class StudentRepository {

    private final EntityManager entityManager;


    public StudentRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }
    public void saveStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }


    public Student findStudentById(Long studentId) {
        return entityManager.find(Student.class, studentId);
    }

    public List<Student> findAllStudents() {
        return entityManager.createQuery("select s from Student s", Student.class)
                .getResultList();
    }
    public void deleteStudentById(Long studentId) {
        entityManager.getTransaction().begin();
        entityManager.remove(findStudentById(studentId));
        entityManager.getTransaction().commit();
    }

    public List<Student> findGroupById(Long groupId) {
        return entityManager.createQuery("select s from Student s where s.group.id=?1", Student.class)
                .setParameter(1, groupId).getResultList();
    }
    public void updateStudent(Long studentId, Student student) {
        Student student1 = findStudentById(studentId);
        student1.setFirstName(student.getFirstName());
        student1.setEmail(student.getEmail());
        student1.setLastName(student.getLastName());
        student1.setStudyFormat(student.getStudyFormat());
    }
}
