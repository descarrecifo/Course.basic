package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService implements CourseServiceInterfice {
    @Autowired
    CourseRepository repository;

    @Override
    public List<Course> getAllCourse() {

        return (List<Course>) repository.findAll();
    }


    @Override
    public Course getCourseById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveCourse(Course course) {

        repository.save(course);
    }

    @Override
    public void deleteCourse(int id) {

        repository.deleteById(id);

    }
}
