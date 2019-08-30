package com.ahmedeid.student.DAO;

import java.util.List;
import com.ahmedeid.student.entities.Student;

// this interface student for make crud operation on student

public interface StudentDAO {
	
	public List<Student> getAllStudent();
	public Student getByStudentId(Integer student_id);
	public Student saveStudent(Student student);
	public Student updateStudent(Student student);
	public String deleteStudent(Integer student_id);

}
