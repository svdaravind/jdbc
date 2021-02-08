package com.newww;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {
		System.out.println("Enter id you want to delete");
		Scanner sc = new Scanner(System.in);
		int id=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishdb", "root", "");
			Statement stmt = con.createStatement();

			String sql = "DELETE FROM student WHERE id=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Deleted id "+id+" from the database...");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		}

	}


