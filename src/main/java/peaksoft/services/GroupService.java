package peaksoft.services;

import org.springframework.stereotype.Service;
import peaksoft.models.Course;
import peaksoft.models.Group;
import peaksoft.repositories.CourseRepository;
import peaksoft.repositories.GroupRepository;
import java.util.List;
@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

    public GroupService(GroupRepository groupRepository, CourseRepository courseRepository) {
        this.groupRepository = groupRepository;
        this.courseRepository = courseRepository;
    }
    public void saveGroup(Group group, Long courseId) {
        Course course = courseRepository.findCourseById(courseId);
        group.setCourse(course);
        course.setGroup(group);
        groupRepository.saveGroup(group);
    }

    public Group findGroupById(Long groupID) {
        return groupRepository.findGroupById(groupID);
    }

    public List<Group> findAllGroups() {
        return groupRepository.findAllGroups();
    }

    public void removeGroupById(Long groupId) {
        groupRepository.removeGroupById(groupId);
    }
    public List<Group> findByCourseId(Long courseId) {
        return groupRepository.findCourseById(courseId);
    }
    public void updateGroup(Long groupId, Group group) {
        groupRepository.updateGroup(groupId, group);
    }
}

