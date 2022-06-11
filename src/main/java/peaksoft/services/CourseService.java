package peaksoft.services;

import org.springframework.stereotype.Service;
import peaksoft.models.Company;
import peaksoft.models.Course;
import peaksoft.repositories.CompanyRepository;
import peaksoft.repositories.CourseRepository;
import java.util.List;
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;

    public CourseService(CourseRepository courseRepository, CompanyRepository companyRepository) {
        this.courseRepository = courseRepository;
        this.companyRepository = companyRepository;
    }
    public void saveCourse(Course course, Long companyId) {
        Company company = companyRepository.findCompanyById(companyId);
        company.setCourse(course);
        course.setCompany(company);
        courseRepository.saveCourse(course);
    }
    public Course findCourseById(Long courseId) {
        return courseRepository.findCourseById(courseId);
    }
    public List<Course> findAllCourses() {
        return courseRepository.findAllCourses();
    }
    public void deleteCourseById(Long courseId) {
        courseRepository.deleteCourseById(courseId);
    }
    public List<Course> findCompanyById(Long companyId) {
        return courseRepository.findCompanyById(companyId);
    }
    public void updateCourse(Long courseID, Course course) {
        courseRepository.updateCourse(courseID,course );
    }
}
