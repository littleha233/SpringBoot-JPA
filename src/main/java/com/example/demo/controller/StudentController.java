package com.example.demo.controller;


import com.example.demo.Service.StudentRepository;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;


    //获取全部学生信息
    @RequestMapping("/getList")
    public List<Student> getStuList(){
        return studentRepository.findAll();
    }


    //添加学生
    @PostMapping("/add")
    public Student addStu(@RequestParam("name") String name,@RequestParam("age") Integer age){
        Student stu = new Student();
        stu.setName(name);
        stu.setAge(age);
        //将数据保存至DB
        return studentRepository.save(stu);
    }


    //根据id查询学生，返回一个具体的学生信息,根据id进行查询是接口自带的功能，若要根据其他信息进行查询需要在接口中进行声明
    //optional用于解决空指针问题，此方法查询的结果可以为空也可以不为空
    @GetMapping(value = "/getStu/{id}")
    public Optional<Student> getStu(@PathVariable("id") Integer id){
        return studentRepository.findById (id);
    }

    //更新或者说修改学生信息
    @PostMapping("/update")
    public Student updateStu(Integer id, @RequestParam("name") String name, @RequestParam("age") Integer age){
        Optional<Student> students = this.getStu (id);
        Student stu = students.get();
        stu.setId (id);
        stu.setName (name);
        stu.setAge (age);
        //将修改结果同步到数据库中
        return studentRepository.save(stu);
    }

    //根据id删除数据
    @DeleteMapping("/delete")
    public void deleteStu(Integer id){
        studentRepository.deleteById(id);
    }

    //根据姓名进行查询
    //url中参数名需要和PathVariable中的参数一一对应，否则报错
    @GetMapping("/getStuByName/{name}")
    public List<Student> findStuByName(@PathVariable("name") String name){
        return studentRepository.findStudentByName(name);
    }

    //与上类似，根据年龄查询学生
    @GetMapping("/getStuByAge/{age}")
    public List<Student> findStuByAge(@PathVariable("age") Integer age){
        return studentRepository.findStudentByAge(age);
    }

}
