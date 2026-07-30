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
 * Servlet implementation class DeleteCustomerServlet
 *
 * GET  /DeleteCustomerServlet?cid=1   -> loads the customer and shows delete.jsp for confirmation
 * POST /DeleteCustomerServlet         -> actually deletes the row and forwards back to the list
 */
@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
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

	/**
	 * Shows the confirmation page with the customer's details loaded up.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int cid = Integer.parseInt(request.getParameter("cid"));
			Customer c = new Customer();

			String query = "select * from customer where cid = ?";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setCity(rs.getString(3));
			} else {
				request.setAttribute("errorMessage", "No customer found with id " + cid);
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				return;
			}

			request.setAttribute("customer", c);
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);

		} catch (NumberFormatException | SQLException e) {
			request.setAttribute("errorMessage", "Unable to load customer for deletion.");
			request.setAttribute("exception", e);
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * Performs the actual delete once the user confirms on delete.jsp.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int cid = Integer.parseInt(request.getParameter("cid"));

			String query = "delete from customer where cid = ?";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, cid);
			ps.executeUpdate();

			RequestDispatcher rd = request.getRequestDispatcher("CustomerDetailsServlet");
			rd.forward(request, response);

		} catch (NumberFormatException | SQLException e) {
			request.setAttribute("errorMessage", "Unable to delete customer.");
			request.setAttribute("exception", e);
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
