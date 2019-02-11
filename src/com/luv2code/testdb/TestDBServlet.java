package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//Connection variables
		String userName = "postgres";
		String password = "postgres";
		String jdbcURL = "jdbc:postgresql://localhost:5432/new";
		String Driver = "org.postgresql.Driver";
	//Connection to db
		try {
			PrintWriter writer = response.getWriter();
			writer.println("Connecting  to DB"+jdbcURL);
			Class.forName(Driver);
			Connection con = DriverManager.getConnection(jdbcURL,userName,password);
			writer.println("Connection Successfull");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
	
	}

}
