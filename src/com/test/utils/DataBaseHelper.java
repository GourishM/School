package com.test.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHelper {
	public static Connection c = null;

	public DataBaseHelper() {
		// TODO Auto-generated constructor stub
	}

	public static void initDB() {
		try {
			System.out.println("Init ------> ");
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Dell/Desktop/School.sqlite");
		} catch (Exception e) {
			System.out.println("Exception Occured --> " + e.getMessage());
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static void insertStudentInfo(String name, String rollNo, String section, String age, String address) {
		try {
			String query = "INSERT INTO StudentsInfo (Name,RollNo,Class,Age,Address) VALUES ("
					+ convertToQueryString(name, ",") + convertToQueryString(rollNo, ",")
					+ convertToQueryString(section, ",") + convertToQueryString(age, ",")
					+ convertToQueryString(address, "") + ");";
			System.out.println("Query--> " + query);

			ResultSet result = c.createStatement().executeQuery(query);
			result = null;
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static ResultSet getStudentInfo() {
		try {
			return c.createStatement().executeQuery("SELECT usn FROM CollegeInfo;");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public static void insertBusInfo(String drivername, String inchargename, String registration, String busno,
			String routeno, String longitude, String latitude) {
		try {
			String query = "INSERT INTO BusInfo (DriverName,InchargeName,Registration,BusNo,RouteNo,Longitude,Latitude) VALUES ("
					+ convertToQueryString(drivername, ",") + convertToQueryString(inchargename, ",")
					+ convertToQueryString(registration, ",") + convertToQueryString(busno, ",")
					+ convertToQueryString(routeno, ",") + convertToQueryString(longitude, ",")
					+ convertToQueryString(latitude, "") + ");";
			System.out.println("Query--> " + query);

			ResultSet result = c.createStatement().executeQuery(query);
			result = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateBusInfo(String drivername, String inchargename, String registration, String busno,
			String routeno, String latitude , String longitude) {
		try {
			String a = "UPDATE BusInfo SET DriverName='haanesh',InchargeName='55',Registration='1523',BusNo='1',RouteNo='09',Longitude='1455.42',Latitude='25.25' WHERE rowid = '1';";
			String query = "UPDATE BusInfo SET " + ("DriverName=" + convertToQueryString(drivername, ","))
					+ ("InchargeName=" + convertToQueryString(inchargename, ","))
					+ ("Registration=" + convertToQueryString(registration, ","))
					+ ("BusNo=" + convertToQueryString(busno, ",")) + ("routeno=" + convertToQueryString(routeno, ","))+ ("Latitude=" + convertToQueryString(latitude, ","))
					+ ("Longitude=" + convertToQueryString(longitude, ""))
				    + " WHERE "+ ("BusNo=" + convertToQueryString(busno, ""));
			System.out.println("Query--> " + query);

			ResultSet result = c.createStatement().executeQuery(query);
			result = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ResultSet getBusInfo() {
		try {
			
			return c.createStatement().executeQuery("SELECT usn FROM CollegeInfo;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String convertToQueryString(String string, String delimiter) {
		return "\'" + string + "\'" + delimiter;
	}
}
