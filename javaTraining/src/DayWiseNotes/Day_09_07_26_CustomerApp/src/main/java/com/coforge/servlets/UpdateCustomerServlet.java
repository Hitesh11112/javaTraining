package com.coforge.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.coforge.model.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	static Connection con = null;

    @Override
    public void init() throws ServletException {
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
		
		 int cid = Integer.parseInt(request.getParameter("cid"));
	        Customer c = new Customer();

	        String query = "select * from customer where cid = ?";
	        try {
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, cid);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                c.setCid(rs.getInt(1));
	                c.setCname(rs.getString(2));
	                c.setCity(rs.getString(3));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        request.setAttribute("customer", c);
	        RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
	        rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
        String cname = request.getParameter("cname");
        String city = request.getParameter("city");

        String query = "update customer set cname = ?, city = ? where cid = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cname);
            ps.setString(2, city);
            ps.setInt(3, cid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("CustomerDetailsServlet");
        rd.forward(request, response);
	}

}
