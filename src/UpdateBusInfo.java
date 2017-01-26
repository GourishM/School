
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

public class UpdateBusInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public UpdateBusInfo() {
	}

	public void init() throws ServletException {

		DataBaseHelper.initDB();
		// out.println("Opened database successfully");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String drivername = request.getParameter("drivername");
		String inchargename = request.getParameter("inchargename");
		String registration = request.getParameter("registration");
		String busno = request.getParameter("busno");
		String routeno = request.getParameter("routeno");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");

		DataBaseHelper.updateBusInfo(drivername, inchargename, registration, busno, routeno, longitude, latitude);
			
	}

}
