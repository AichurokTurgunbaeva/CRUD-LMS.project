package peaksoft.repositories;

import org.springframework.stereotype.Repository;
import peaksoft.models.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class CourseRepository {
    private final EntityManager entityManager;

    public CourseRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void saveCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
    }

    public Course findCourseById(Long courseId) {
        return entityManager.find(Course.class, courseId);
    }

    public List<Course> findAllCourses() {
        return entityManager
                .createQuery("select c from Course c", Course.class)
                .getResultList();
    }

    public void deleteCourseById(Long courseId) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Course course = findCourseById(courseId);
        entityManager.remove(entityManager.contains(course)?course: entityManager.merge(course));

        transaction.commit();
    }

    public List<Course> findCompanyById(Long companyId) {
        return entityManager
                .createQuery("select s from Course s where s.company.id = :companyId", Course.class)
                .setParameter("companyId", companyId)
                .getResultList();
    }


    public void updateCourse(Long courseID, Course newCourse) {
        Course course1 = findCourseById(courseID);
        course1.setCourseName(newCourse.getCourseName());
        course1.setDuration(newCourse.getDuration());
        entityManager.persist(course1);

    }
}
