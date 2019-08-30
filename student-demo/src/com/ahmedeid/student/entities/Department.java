package com.ahmedeid.student.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name="department")
@Transactional
public class Department {
	
	@Id
	@Column(name="dept_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dept_id;
	
	@Column(name="dept_name")
	private String dept_name;
	
	@OneToMany(mappedBy = "department",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="dept_id")
	private List<Student> student;
	
	public void addStudents(Student students) {
		if(student == null) {
			student = new ArrayList<>();
		}
		student.add(students);
	}
	
	public Department() {
		super();
	}
	
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public Department(String dpet_name) {
		super();
		this.dept_name = dpet_name;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getDpet_name() {
		return dept_name;
	}

	public void setDpet_name(String dpet_name) {
		this.dept_name = dpet_name;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + "]";
	}
	
	
}
