package peaksoft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Course;
import peaksoft.services.CompanyService;
import peaksoft.services.CourseService;

import java.util.List;

@Controller
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;
    private final CompanyService companyService;

    public CourseController(CourseService courseService, CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }
    @ModelAttribute("courses")
    public List<Course> courses(){
        return courseService.findAllCourses();
    }
    @GetMapping("find/by/{companyId}")
    public String findAllCoursesByCompanyId(@PathVariable Long companyId, Model model) {

        List<Course> courses = courseService.findCompanyById(companyId);
        model.addAttribute("courses", courses);
        model.addAttribute("companyId", companyId);
        return "courses/allCourses";
    }

    @GetMapping("/save/{companyId}")
    public String showCourseSavePage(@PathVariable Long companyId, Model model) {
        model.addAttribute("companyId", companyId);
        model.addAttribute("emptyCourse", new Course());
        return "courses/saveNewCourse";

    }
    @PostMapping("/save/{companyId}")
    public String saveCourse(Course course, @PathVariable Long companyId){
        courseService.saveCourse(course, companyId);
        return "redirect:/api/courses/find/by/"+companyId;

    }
    @GetMapping("/update/{courseId}")
    public String updateCourse(Model model, @PathVariable Long courseId){
        Course course = courseService.findCourseById(courseId);
        model.addAttribute("updateCourse", course);
        return "courses/updateCourse";
    }

    @PostMapping ("/update/{courseId}")
    public String updateCourse(Course course, @PathVariable Long courseId){
        Course courseById = courseService.findCourseById(courseId);
        Long id = courseById.getCompany().getId();
        courseService.updateCourse(courseId, course);
        return "redirect:/api/courses/find/by/" + id;
    }
    @GetMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable Long courseId){
        Course course = courseService.findCourseById(courseId);
        Long id = course.getCompany().getId();
        courseService.deleteCourseById(courseId);
        return "redirect:/api/courses/find/by/"+id;
    }
}
