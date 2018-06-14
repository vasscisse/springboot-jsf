package com.art.software.programming.service;

import com.art.software.programming.model.Course;

import java.util.List;
/**
 * @author Vass Cisse
 */
public interface CourseService {

    List<Course> getAllCourses();
    Course getCourseById(long id);
    void saveCourse(Course course);
}
