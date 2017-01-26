
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.utils.DataBaseHelper;

public class InsertStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertStudentInfo() {
	}

	public void init() throws ServletException {

		DataBaseHelper.initDB();
		// out.println("Opened database successfully");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h3>Insert in to Student Info Servlet !!!</h3>");
		String name = request.getParameter("name");
		String rollNo = request.getParameter("rollnumber");
		String section = request.getParameter("section");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		DataBaseHelper.insertStudentInfo(name,rollNo,section,age,address);

	}

}
