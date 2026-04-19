package com.jackie.student_api.controller;
import com.jackie.student_api.exception.ApiResponse;
import com.jackie.student_api.DTO.StudentDTO;
import com.jackie.student_api.model.Student;
import com.jackie.student_api.result.Result;
import com.jackie.student_api.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // ✅ GET ALL (DTO)
    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    // ✅ ADD
    @PostMapping
    public ResponseEntity<Result> addStudent(@Valid @RequestBody StudentDTO dto)
    {
        Result result = studentService.addStudent(dto);
        return result.isSuccess()
                ? ResponseEntity.status(201).body(result)
                : ResponseEntity.badRequest().body(result);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Result> updateStudent(@PathVariable int id, @RequestBody StudentDTO dto)
    {
        Result result = studentService.updateStudent(id, dto);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.badRequest().body(result);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteStudent(@PathVariable int id)
    {
        Result result = studentService.deleteStudent(id);
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getStudentById(@PathVariable int id)
    {
        StudentDTO student = studentService.getStudentById(id);
        if (student != null)
        {
            return ResponseEntity.ok(new ApiResponse<>(200, "Student fetched successfully", student)
            );
        }
        else
        {
            return ResponseEntity.status(404).body(new ApiResponse<>(404, "Student not found", null)
            );
        }
    }

    @GetMapping("/page")
    public Page<Student> getStudentsPage(@RequestParam int page,@RequestParam int size,@RequestParam String sort)
    {
        return studentService.getStudentsWithPagination(page, size, sort);
    }

    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String name)
    {
        return studentService.searchStudentsByName(name);
    }
}
