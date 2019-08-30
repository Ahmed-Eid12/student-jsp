package com.ahmedeid.student.controlling;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahmedeid.student.DAO.StudentDAO;
import com.ahmedeid.student.DAOImpl.StudentDAOImpl;
import com.ahmedeid.student.entities.Student;

/**
 * Servlet implementation class HomeController
 * @author Developer ahmed eid java and nodeJS developer
 * 
 * this for home student or get all student informations
 */
@WebServlet("/allStudents")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDAO studentDao = StudentDAOImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Student> students = studentDao.getAllStudent();
		request.setAttribute("allStudents", students);
		
		request.getRequestDispatcher("about student.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
