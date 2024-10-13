package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * @return a Jason
     */
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/addStudent")
    public void addStudents() {
        if (studentService.addStudent(
                new Student("Mario bbb",
                   LocalDate.of(1986, 5, 27),
                "mario@gmail.com")) != null) {
            System.out.println("new Student is added");
        }
    }
    @PostMapping
    public void signNewStudent(@RequestBody Student student){
        studentService.addNewStudentWithPost(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudentById(id);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                             @RequestParam(required = false) String name,
                              @RequestParam(required = false) String Email){
        
    }


}
//call a rest  template to call a third party service
   /* @GetMapping("/load")
    public String loadPosts(){
        return "all posts";    }*/



