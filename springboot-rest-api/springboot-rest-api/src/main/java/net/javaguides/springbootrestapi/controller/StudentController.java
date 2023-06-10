package net.javaguides.springbootrestapi.controller;

import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1,"Angeline","Sophia");
        return student;
    }

    @GetMapping("/allStudent")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> st = new ArrayList<>();
        st.add(new Student(1,"Angeline","Sophia"));
        st.add(new Student(2,"ANitha","Loraine"));
        st.add(new Student(3,"Andrea","Sharon"));
        st.add(new Student(4,"Arun","Stanley"));
        st.add(new Student(5,"Jayanthi","R"));
        return new ResponseEntity<>(st,HttpStatus.OK);
    }

    @GetMapping("/allStudent/{id}/{firstName}/{lastName}")
    public ResponseEntity<Student> setPathVariableForStudent(@PathVariable("id") int studentId,
                                             @PathVariable("firstName") String  firstName,
                                             @PathVariable("lastName") String lastName){
        return new ResponseEntity<>(new Student(studentId,firstName,lastName), HttpStatus.OK);
    }

    @GetMapping("/allStudent/query")
    public ResponseEntity<Student> getQueryParamsForStudent(@RequestParam("id") int studentId,
                                             @RequestParam("firstName") String  firstName,
                                             @RequestParam("lastName") String lastName){
//        return new Student(studentId,firstName,lastName);
        return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body(new Student(studentId,firstName,lastName));
    }


    @PostMapping("/create")
    public ResponseEntity<Student> creatStudent(@RequestBody Student st){
        System.out.println(st.getId());
        System.out.println(st.getFirstName());
        System.out.println(st.getLastName());
        return ResponseEntity.ok(st);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student st,@PathVariable("id") int studentId){
        System.out.println(st.getId());
        System.out.println(st.getFirstName());
        System.out.println(st.getLastName());
        return new ResponseEntity<>(st,HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Object> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok().header("custom-header","angeline").body("student deleted successfully!!!!!1");
    }

    @GetMapping("/")
    public ResponseEntity<Student> getStudents(){
        Student student = new Student(1,"Angeline","Sophia");
//        return new ResponseEntity<>(student,HttpStatus.OK);
//        return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header","angeline").body(student);
//        return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body(student);
    }

//    public ResponseEntity<?>
}
