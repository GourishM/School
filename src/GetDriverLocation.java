
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

public class GetDriverLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public GetDriverLocation() {
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
		out.print("<h3>Hello Darshan, Welcome to First Servlet !!!</h3>");
		String usn = request.getParameter("usn");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String college = request.getParameter("college");
		out.println(usn);
		out.println(name);
		out.println(age);
		out.print(college);

		try {
			ResultSet rs = DataBaseHelper.getStudentInfo();
			while (rs.next()) {
				out.println("USN from Database --> " + rs.getString("usn"));
				/*out.println("NAME from Database --> " + rs.getString("name"));
				out.println("AGE from Database --> " + rs.getInt(1));
				out.println("COLLEGE from Database --> " + rs.getString("college"));*/

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("</body></html>");
	}

}
