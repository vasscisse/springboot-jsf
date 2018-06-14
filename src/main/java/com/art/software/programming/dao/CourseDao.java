package com.art.software.programming.dao;

import com.art.software.programming.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Vass Cisse
 */
public interface CourseDao extends JpaRepository<Course, Long> {

}
