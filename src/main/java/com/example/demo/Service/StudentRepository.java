package com.example.demo.Service;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findAll();

    Student save(Student stu);

    Student findStuById(int id);

    void deleteById(Integer id);

    //根据姓名查询学生
    List<Student> findStudentByName(String name);
    //根据年龄查询学生
    List<Student> findStudentByAge(Integer age);
}
