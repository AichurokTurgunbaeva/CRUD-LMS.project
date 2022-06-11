package peaksoft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.models.Teacher;
import peaksoft.services.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/api/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping("/find/by/{courseId}")
    public String findTeacherByCourseId(@PathVariable Long courseId, Model model) {
        List<Teacher> teachers = teacherService.findCourseById(courseId);
        model.addAttribute("courseId", courseId);
        model.addAttribute("teachers", teacherService.findAllTeachers());
        return "/teachers/allTeachers";
    }

    @GetMapping("/save/{courseId}")
    public String showTeacherSavePage(@PathVariable Long courseId, Model model) {
        model.addAttribute("courseId", courseId);
        model.addAttribute("emptyTeacher", new Teacher());
        return "/teachers/saveNewTeacher";
    }

    @PostMapping("/save/{courseId}")
    public String saveTeacher(@PathVariable("courseId") Long courseId, Teacher teacher) {
        teacherService.saveTeacher(teacher, courseId);
        return "redirect:/api/teachers/find/by/" + courseId;
    }
    @GetMapping("/update/{teacherId}")
    public String updateTeacher(Model model, @PathVariable Long teacherId){
        Teacher teacher = teacherService.findTeacherById(teacherId);
        model.addAttribute("updateTeacher", teacher);
        return "/teachers/updateTeacher";
    }
    @PostMapping("/update/{teacherId}")
    public String updateTeacher(Teacher teacher, @PathVariable Long teacherId){
        Teacher id = teacherService.findTeacherById(teacherId);
        Long id1 = id.getCourse().getId();
        teacherService.updateTeacher(teacherId,teacher);
        return "redirect:/api/teachers/find/by/" + id1;
    }

    @GetMapping("/delete/{teacherId}")
    public String deleteTeacher(@PathVariable("teacherId") Long teacherId, Model model){
        System.out.println("teacherId = " + teacherId);

        Teacher teacher = teacherService.findTeacherById(teacherId);

        Long id1 = teacher.getCourse().getId();

        teacherService.deleteTeacherById(teacherId);

        model.addAttribute("courseId", id1);
        model.addAttribute("teachers", teacherService.findAllTeachers());

        return "/teachers/allTeachers";
    }
}
