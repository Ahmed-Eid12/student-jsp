package com.ahmedeid.student.controlling;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahmedeid.student.DAO.StudentDAO;
import com.ahmedeid.student.DAOImpl.StudentDAOImpl;
import com.ahmedeid.student.entities.Student;

/**
 * Servlet implementation class AddNewStudent
 */
@WebServlet("/AddNewStudent")
public class AddNewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDAO studentDao = StudentDAOImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String student_name = request.getParameter("student_name");
		String student_email = request.getParameter("student_email");
		Integer dept_id = Integer.parseInt(request.getParameter("student-department"));
		
		Student student = new Student(student_name,student_email,dept_id);
		if(student != null) {
			studentDao.saveStudent(student);
		} else {
			request.getRequestDispatcher("not-found.jsp").forward(request, response);
		}
		request.getRequestDispatcher("about student.jsp").forward(request, response);
	}

}
