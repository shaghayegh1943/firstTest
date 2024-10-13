package com.example.demo.student;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<String> Hello() {
        return List.of("Hello Again.", "im back!");
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    public Student addStudent(Student student){
      return   studentRepository.save(student);
    }

    public void addNewStudentWithPost(Student student) {
        Optional<Student> studentByByEmail = studentRepository.
                findStudentByByEmail(student.getEmail());
        if(studentByByEmail.isPresent()){
            throw new IllegalStateException("Email is taken");
        }

        System.out.println(studentRepository.save(student));
    }

    public void deleteStudentById(Long id) {
        boolean exist = studentRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("student with id "+ id + "does not exits.");
        }
        studentRepository.deleteStudentById(id);
    }
}
