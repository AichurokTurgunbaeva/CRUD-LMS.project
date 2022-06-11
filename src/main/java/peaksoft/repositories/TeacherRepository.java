package peaksoft.repositories;

import org.springframework.stereotype.Repository;
import peaksoft.models.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;
@Repository
public class TeacherRepository {
    private final EntityManager entityManager;

    public TeacherRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }
    public void saveTeacher(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
    }

    public Teacher findTeacherById(Long teacherId) {
        return entityManager.find(Teacher.class, teacherId);
    }

    public List<Teacher> findAllTeachers() {
        return entityManager.createQuery("select t from Teacher t", Teacher.class)
                .getResultList();
    }

    public void deleteTeacherById(Long teacherId) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(entityManager.find(Teacher.class, teacherId));

        transaction.commit();
    }

    public List<Teacher> findCourseById(Long courseId) {
        List<Teacher> teachers = entityManager.createQuery("select t from Teacher t where t.course.id=?1", Teacher.class)
                .setParameter(1, courseId).getResultList();

        return teachers;
    }
    public void updateTeacher(Long teacherId, Teacher teacher) {
        Teacher teacher1 = findTeacherById(teacherId);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setLastName(teacher.getLastName());
        entityManager.persist(teacher1);
    }
}

