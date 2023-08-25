package com.piyush.MVCProject.controller;

import com.piyush.MVCProject.entity.Student;
import com.piyush.MVCProject.service.StudentService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    // We don't have to use @Autowired annotation here because spring bean(StudentController) has only one constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // handler method to handle ListStudents request and return model and view
    @GetMapping("/students")
    public String listStudents(Model model){

        // Adds data to the model
        // This method has key value pair, Key: students, value: list of students from database
        model.addAttribute("students", studentService.getAllStudents());

        //Model has a list of students, now we are gonna display students in view students.html

        //The "students" in file students.html's th:each = "student: ${students}" is the key.
        //It contains list of all the students

        //we return a view from this method. students.html
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        //We create empty student object to hold Student-Form data
        Student student = new Student();

        //The "student" key will contain a empty Student object which will be used to hold Student Form data
        model.addAttribute("student", student);

        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    //Update Page handler
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model){
        //get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    //Delete student handler
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}
