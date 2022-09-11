package com.ease.thymeleaf.controllers;

import com.ease.thymeleaf.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloControllers {

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @RequestMapping("/sendData")
    public ModelAndView sendData(){
        ModelAndView modelAndView = new ModelAndView("data");
        modelAndView.addObject("message", "We will overcome");
        return modelAndView;
    }

    @RequestMapping("/student")
    public ModelAndView getStudent(){
        ModelAndView modelAndView = new ModelAndView("student");
        Student student = new Student();
        student.setName("Busola");
        student.setScore(99);
        modelAndView.addObject("student", student);
        return modelAndView;
    }
    @RequestMapping("/students")
    public ModelAndView getStudents(){
        ModelAndView modelAndView = new ModelAndView("students");

        Student student = new Student();
        student.setName("Busola");
        student.setScore(99);

        Student student1 = new Student();
        student1.setName("Gbemi");
        student1.setScore(81);

        List<Student> studentList = Arrays.asList(student, student1);
        modelAndView.addObject("students", studentList);
        return modelAndView;
    }

    @RequestMapping("/studentForm")
    public ModelAndView studentForm(){
        ModelAndView modelAndView = new ModelAndView("studentForm");

        Student student = new Student();
        student.setName("Sam");
        student.setScore(79);

        modelAndView.addObject("studentForm", student);

        return modelAndView;
    }

    @RequestMapping("/saveStudent")
    public ModelAndView sveStudent(@ModelAttribute Student student){
        ModelAndView modelAndView = new ModelAndView("result");
        System.out.println(student.getName());
        System.out.println(student.getScore());
        return modelAndView;

    }

}
