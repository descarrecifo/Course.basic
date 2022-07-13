package com.example.demo.service;

import com.example.demo.model.Course;

import java.util.List;

public interface CourseServiceInterfice  {

    List<Course> getAllCourse();

    Course getCourseById(int id);

    void saveCourse(Course course);

    void deleteCourse(int id);
}
