package com.jackie.student_api.DTO;

import jakarta.validation.constraints.*;

public class StudentDTO
{
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Course cannot be empty")
    private String course;

    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

    //public StudentDTO() {}

    public StudentDTO(String name, String course, int age)
    {
        this.name = name;
        this.course = course;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}