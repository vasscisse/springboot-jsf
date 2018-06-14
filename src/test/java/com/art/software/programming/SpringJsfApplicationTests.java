package com.art.software.programming;

import com.art.software.programming.model.Course;
import com.art.software.programming.service.CourseService;
import com.art.software.programming.web.CourseBean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * @author Vass Cisse
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SpringJsfApplicationTests {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseBean courseBean;

	@Test
	public void contextLoads() {
		assertNotNull(dataSource);
		assertNotNull(courseService);
		assertNotNull(courseBean);
	}

	@Before
	public void beforeTests() {
		Course course1 = new Course(1, "Maths", "Study of  the Pythagorean theorem.");
		Course course2 = new Course(2, "Politics", "The art of saying strange things.");
		Course course3 = new Course(3, "Physics", "Study of matter, its motion and behavior.");
		courseService.saveCourse(course1);
		courseService.saveCourse(course2);
		courseService.saveCourse(course3);
	}

	@Test
	public void testDataSourceType() {
		// This is not really necessary but it helps to show
		// Spring Boot is using Hikari CP
		assertTrue(dataSource.toString().startsWith("HikariDataSource"));
	}

	@Test
	public void testFindOne() {
		Course selectedCourse = courseService.getCourseById(2);
		assertNotNull(selectedCourse);
		assertTrue(selectedCourse.getId() == 2);
	}

	@Test
	public void testCourseBean() {
		// this also test courseService.getAllCourses
		List<Course> all = courseBean.getListOfCourses();
		assertNotNull(all);
		assertTrue(all.size() > 0);
	}
}
