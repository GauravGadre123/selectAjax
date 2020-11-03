package myapp.com.techno;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ListAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("i m in post");

		int id = Integer.parseInt(request.getParameter("id"));

		

		try {
			List<Category> listCatagory = CategoryDAO.list(id);

			String json = new Gson().toJson(listCatagory);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			response.getWriter().write(json);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
