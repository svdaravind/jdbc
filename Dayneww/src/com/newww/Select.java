package com.newww;

import java.sql.*;

public class Select {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishdb", "root", "");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from student");

			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getInt(4));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
