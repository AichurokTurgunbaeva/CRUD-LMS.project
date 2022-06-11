package peaksoft.services;

import org.springframework.stereotype.Service;
import peaksoft.models.Course;
import peaksoft.models.Teacher;
import peaksoft.repositories.CourseRepository;
import peaksoft.repositories.TeacherRepository;

import java.util.List;
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public TeacherService(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    public void saveTeacher(Teacher teacher, Long courseId) {
        Course course = courseRepository.findCourseById(courseId);
        course.setTeacher(teacher);
        teacher.setCourse(course);
        teacherRepository.saveTeacher(teacher);
    }
    public Teacher findTeacherById(Long teacherId) {
        return teacherRepository.findTeacherById(teacherId);
    }

    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAllTeachers();
    }

    public void deleteTeacherById(Long teacherId) {
        teacherRepository.deleteTeacherById(teacherId);
    }
    public List<Teacher> findCourseById(Long courseId) {
        return teacherRepository.findCourseById(courseId);
    }
    public void updateTeacher(Long teacherId, Teacher teacher){
        teacherRepository.updateTeacher(teacherId, teacher);
    }
}

