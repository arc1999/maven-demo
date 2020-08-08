package com.lti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.ProductDao;
import com.lti.entity.Product;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product p = new Product();
		p.setId(Integer.parseInt(request.getParameter("Id")));
		p.setName(request.getParameter("Name"));
		p.setPrice(Integer.parseInt(request.getParameter("Price")));

		ProductDao dao = new ProductDao();
		dao.insert(p);
		response.getWriter().write("product added sucessfully");
	}
}
