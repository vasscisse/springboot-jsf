package com.art.software.programming.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Vass Cisse
 */
@Entity
@Table(name = "TEST")
public class Course implements java.io.Serializable {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 2, scale = 0)
	private long id;

	@Column(name = "NAME", nullable = false, length = 20)
	private String name;

	@Column(name = "DESCRIPTION", nullable = false, length = 100)
	private String description;

	public Course() {
	}

	public Course(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
