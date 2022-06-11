package peaksoft.repositories;

import org.springframework.stereotype.Repository;
import peaksoft.models.Group;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
@Repository
public class GroupRepository {

    private final EntityManager entityManager;

    public GroupRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void saveGroup(Group group) {
        entityManager.getTransaction().begin();
        entityManager.persist(group);
        entityManager.getTransaction().commit();

    }

    public Group findGroupById(Long groupID) {
        return entityManager.find(Group.class, groupID);
    }

    public List<Group> findAllGroups() {
        return entityManager.createQuery("select g from Group g", Group.class)
                .getResultList();
    }

    public void removeGroupById(Long groupId) {
        entityManager.remove(findGroupById(groupId));
    }

    public List<Group> findCourseById(Long courseId) {
        return entityManager.createQuery("select g from Group g where (select c from Course c where c.id = ?1) member of g.courses", Group.class)
                .setParameter(1, courseId).getResultList();
    }
    public void updateGroup(Long groupId, Group group) {
        Group group1 = findGroupById(groupId);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
        entityManager.persist(group1);
    }
}


