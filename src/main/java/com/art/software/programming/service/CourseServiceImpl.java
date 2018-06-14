package com.art.software.programming.service;

import com.art.software.programming.dao.CourseDao;
import com.art.software.programming.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author Vass Cisse
 */
@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) courseDao.findAll();
    }

    @Override
    public Course getCourseById(long id) {
        return courseDao.findOne(id);
    }

    @Override
    public void saveCourse(Course course) {
        courseDao.save(course);
    }
}
