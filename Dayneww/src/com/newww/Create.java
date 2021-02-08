package com.newww;

import java.sql.*;

public class Create {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishdb", "root", "");
			Statement stmt = con.createStatement();

			String sql = "CREATE TABLE Student " + "(id INTEGER not NULL, " + " name VARCHAR(255), "+ " city VARCHAR(255), "
					+ " age INTEGER, " + " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (Exception e) {
			System.out.println("Exception...");
			e.printStackTrace();
		}

	}

}
