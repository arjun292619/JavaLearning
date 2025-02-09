package net.javaguides.spring_boot_restapi.controller;

import net.javaguides.spring_boot_restapi.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    //    http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Steve", "Rogers");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //    http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        Student student1 = new Student(1, "Steve", "Rogers");
        Student student2 = new Student(2, "Clark", "Kent");
        Student student3 = new Student(3, "Tony", "Stark");
        Student student4 = new Student(4, "Natasha", "Romanoff");
//        return List.of(student1, student2, student3, student4);
        return ResponseEntity.ok().header("custom-x-header", "custom-header").body(List.of(student1, student2, student3, student4));
    }

    //    http://localhost:8080/students/152/bruce/wayne
    @GetMapping("{id}/{fname}/{lname}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long studentId, @PathVariable("fname") String first, @PathVariable("lname") String last) {
        Student student = new Student(studentId, first, last);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    //    http://localhost:8080/students/query?id=134&first=diana&last=prince
    @GetMapping("query")
    public ResponseEntity<Student> getStudentQuery(@RequestParam("id") Long studentId, @RequestParam("first") String fname, @RequestParam("last") String lname) {
        Student student = new Student(studentId, fname, lname);
//        return student;
        return ResponseEntity.ok(student);
    }


    //    http://localhost:8080/students/create
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        Student student1 = new Student(student.getId(), student.getFirstName(), student.getLastName());
//        return student1;
        return ResponseEntity.status(HttpStatus.CREATED).body(student1);
    }

    //     http://localhost:8080/students/update/1456
    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long studentId, @RequestBody Student student) {
        System.out.println(studentId);
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        Student student1 = new Student(studentId, student.getFirstName(), student.getLastName());
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }

    //     http://localhost:8080/students/delete/1456
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId) {
        System.out.println("Student with " + studentId + " deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body("Student with " + studentId + " deleted successfully");
    }
}
