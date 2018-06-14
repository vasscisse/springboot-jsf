package com.art.software.programming.web;

import com.art.software.programming.model.Course;
import com.art.software.programming.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import java.io.IOException;
import java.util.List;
/**
 * @author Vass Cisse
 */
@ManagedBean
@RequestScoped
public class CourseBean {

    private final static String message = "Simple JSF example with Spring Boot";

    @Autowired
    private CourseService courseService;

    private String name;
    private String desc;

    @PostConstruct
    public void init() {
        name = "";
        desc = "";
    }

    public String getMessage() {
        return message;
    }

    public List<Course> getListOfCourses() {
        return courseService.getAllCourses();
    }

    public boolean showDataTable() {
        return getListOfCourses().size() > 0;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String addNewCourse() throws IOException {
        int nextId = courseService.getAllCourses().size() + 1;
        Course newCourse = new Course(nextId, name, desc);
        courseService.saveCourse(newCourse);
        init();

        return "home?faces-redirect=true";
    }
}
