package com.jackie.student_api.repository;
import com.jackie.student_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer>
{
    List<Student> findByNameContainingIgnoreCase(String name);
}