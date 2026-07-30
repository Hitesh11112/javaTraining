package com.coforge.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.coforge.model.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {

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
		
		
		
		List<Customer> customerList = new ArrayList<Customer>();

		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;

		String query = "insert into customer values(?,?,?)";

		try {
			ps = con.prepareStatement(query);

			ps.setInt(1, Integer.parseInt(request.getParameter("cid")));

			ps.setString(2, request.getParameter("cname"));

			ps.setString(3, request.getParameter("city"));

			ps.executeUpdate();

			query = "select * from customer";

			st = con.createStatement();

			rs = st.executeQuery(query);

			while (rs.next()) {
				Customer c = new Customer();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setCity(rs.getString(3));
				customerList.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("customerList", customerList);

		RequestDispatcher rd = request.getRequestDispatcher("details.jsp");

		rd.forward(request, response);
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
