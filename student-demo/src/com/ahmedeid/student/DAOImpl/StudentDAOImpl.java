package com.ahmedeid.student.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ahmedeid.student.DAO.StudentDAO;
import com.ahmedeid.student.entities.Student;
import com.ahmedeid.student.hibernateUtil.HibernateUtil;
import com.ahmedeid.student.moreproperties.Queries;

public class StudentDAOImpl implements StudentDAO {
	
	private static StudentDAOImpl studentDaoImpl = null;
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		// Transaction transaction = session.beginTransaction();
		
		// List<Student> allStudents = session.createCriteria(Student.class).list();
		
		// Queries is a class inside project have all queries 
		Query query = session.createQuery(Queries.ALL_FROM_STUDENT);
		students = query.list();
		
		session.close();
		return students;
	}

	@Override
	public Student getByStudentId(Integer student_id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		// Transaction transaction = session.beginTransaction();
		
		Student getSelectedStudentById = session.get(Student.class, student_id);
		
		session.close();
		return getSelectedStudentById;
	}

	@Override
	public Student saveStudent(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		
		session.close();
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		session.update(student);
		transaction.commit();
		
		session.close();
		return student;
	}

	@Override
	public String deleteStudent(Integer student_id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Student delelteSelectedStudent = session.get(Student.class, student_id);
		
		session.delete(delelteSelectedStudent);
		
		transaction.commit();
		
		session.close();
		
		return null;
	}
	
	// singleton instance 
	public static StudentDAO getInstance() {
		if(studentDaoImpl == null) {
			studentDaoImpl = new StudentDAOImpl();
		}
		return studentDaoImpl;
	}

}
