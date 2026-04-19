package com.jackie.student_api.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jackie.student_api.DTO.StudentDTO;
import com.jackie.student_api.model.Student;
import com.jackie.student_api.repository.StudentRepository;
import com.jackie.student_api.result.Result;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class StudentService {

    private final StudentRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Page<Student> getStudentsWithPagination(int page, int size)
    {
        return repository.findAll(PageRequest.of(2, 10));
    }

    // 🔵 ENTITY → DTO
    private StudentDTO mapToDTO(Student student)
    {
        return new StudentDTO(
                student.getName(),
                student.getCourse(),
                student.getAge()
        );
    }

    // 🔵 DTO → ENTITY
    private Student mapToEntity(StudentDTO dto)
    {
        Student student = new Student();
        student.setName(dto.getName());
        student.setCourse(dto.getCourse());
        student.setAge(dto.getAge());
        return student;
    }

    // ✅ GET ALL (ONLY ONE METHOD)
    public List<StudentDTO> getAllStudents()
    {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Result addStudent(StudentDTO dto)
    {
        logger.info("Adding new student: {}", dto.getName());
        if (dto.getName() == null || dto.getName().isEmpty()) {
            logger.warn("Validation failed: Name is empty");
            return new Result(false, "Name cannot be empty");
        }
        if (dto.getAge() <= 0) {
            logger.warn("Validation failed: Invalid age");
            return new Result(false, "Invalid age");
        }
        Student student = mapToEntity(dto);
        repository.save(student);
        logger.info("Student added successfully: {}", student.getId());
        return new Result(true, "Student added successfully");
    }

    // ✅ UPDATE (DTO)
    public Result updateStudent(int id, StudentDTO dto)
    {
        logger.info("Updating student with id: {}", id);
        Optional<Student> existing = repository.findById(id);

        if (existing.isEmpty())
        {
            logger.error("Update failed: Student not found with id {}", id);
            return new Result(false, "Student not found");
        }
        Student s = existing.get();
        s.setName(dto.getName());
        s.setCourse(dto.getCourse());
        s.setAge(dto.getAge());
                               
        repository.save(s);

        logger.info("Student updated successfully: {}", id);
        return new Result(true, "Student updated successfully");
    }

    // ✅ DELETE
    public Result deleteStudent(int id)
    {
        logger.info("Deleting student with id: {}", id);
        if (!repository.existsById(id)) {
            logger.error("Delete failed: Student not found with id {}", id);
            return new Result(false, "Student not found");
        }
        repository.deleteById(id);
        logger.info("Student deleted successfully: {}", id);
        return new Result(true, "Student deleted successfully");
    }

    //find by ID
    public StudentDTO getStudentById(int id) {

        Optional<Student> student = repository.findById(id);
        if (student.isPresent())
        {
            return mapToDTO(student.get());
        } else
        {
            return null;
        }
    }
}