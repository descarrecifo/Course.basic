package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseServiceInterfice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseServiceInterfice courseServiceInterfice;


    @GetMapping("/")
    public ModelAndView welcomePage(){

        return new ModelAndView("wc");
    }

    // Course List

    @GetMapping("/list")
    public ModelAndView courseList(){

        ModelAndView model =new ModelAndView();
        List<Course> courseList = courseServiceInterfice.getAllCourse();
        model.addObject("courseLists",courseList);
        model.setViewName("course_list");
        return model;
    }


    // add course Page

    @GetMapping("/addCoursePage")
    public ModelAndView addCoursePage(){

        ModelAndView model = new ModelAndView();
        Course course = new Course();
        model.addObject("courseForm",course);
        model.setViewName("form");
        return model;
    }


    // add Course

    @PostMapping("/addCourse")
    public ModelAndView addCourse(@ModelAttribute("courseForm") Course course){

        courseServiceInterfice.saveCourse(course);
        return new ModelAndView("redirect:/list");
    }

    // Delete List

    @GetMapping("/deleteCourse/{courseId}")
    public ModelAndView deleteCourse(@PathVariable("courseId") int id){

        courseServiceInterfice.deleteCourse(id);
        return new ModelAndView("redirect:/list");
    }

    // Update List

    @GetMapping("/updateCourse/{courseId}")
    public ModelAndView updateCourse(@PathVariable("courseId") int id){

        ModelAndView model =new ModelAndView();
        Course course = courseServiceInterfice.getCourseById(id);
        model.addObject("courseForm", course);
        model.setViewName("form");

        return model;
    }
}
