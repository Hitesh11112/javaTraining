package com.coforge.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.coforge.model.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CustomerDetailsServlet
 */
@WebServlet("/CustomerDetailsServlet")
public class CustomerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Connection con = null;
	
	@Override
	public void init() throws ServletException {
		//first life cycle connection created 
		super.init();
		
		ServletContext context = getServletContext();
		
		try {
			Class.forName(context.getInitParameter("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(context.getInitParameter("url"),
					context.getInitParameter("uname"),
					context.getInitParameter("pwd"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
ArrayList<Customer> customerList = new ArrayList<Customer>();

		
		String query="select * from customer";
		
		Statement st=null;
		
		ResultSet rs=null;
		
		try {
			 st=con.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			 rs=st.executeQuery(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			while(rs.next())
			{
				Customer c=new Customer();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setCity(rs.getString(3));
				customerList.add(c);	
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		request.setAttribute("customerList", customerList);
		
		RequestDispatcher rd=request.getRequestDispatcher("details.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}