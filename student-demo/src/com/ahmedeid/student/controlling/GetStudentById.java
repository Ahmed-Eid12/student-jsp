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
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/GetStudentById")
public class GetStudentById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDAO studentDao = StudentDAOImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudentById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// this field not found in ui form there is two way 
		// one : get student by it's id above in form and update it 
		// two : get student bt it's id in another ui form and update it
		Integer student_id = Integer.parseInt(request.getParameter("student_id"));
		// Student student = new Student();
		if(student_id == null) {
			request.getRequestDispatcher("id-not-found.jsp").forward(request, response);
		} else {
			Student student = studentDao.getByStudentId(student_id);
			
			request.setAttribute("studentUpdate", student);
			request.getRequestDispatcher("about student.jsp").forward(request, response);
		}
		
	}

}
