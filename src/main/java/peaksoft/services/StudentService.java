package peaksoft.services;

import org.springframework.stereotype.Service;
import peaksoft.models.Group;
import peaksoft.models.Student;
import peaksoft.repositories.GroupRepository;
import peaksoft.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }
    public void saveStudent(Student student, Long groupId) {
        Group group = groupRepository.findGroupById(groupId);
        group.setStudent(student);
        student.setGroup(group);
        studentRepository.saveStudent(student);
    }

    public Student findStudentById(Long studentId) {
        return studentRepository.findStudentById(studentId);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAllStudents();
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteStudentById(studentId);
    }

    public List<Student> findGroupById(Long groupId) {
        return studentRepository.findGroupById(groupId);
    }
    public void updateStudent(Long studentId, Student student) {
        studentRepository.updateStudent(studentId,student );
    }
}

