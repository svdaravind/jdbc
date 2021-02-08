package com.newww;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
		System.out.println("Enter id you want to Update");
		Scanner sc = new Scanner(System.in);
		int id=sc.nextInt();
		System.out.println("enter name :");
		String name = sc.next();
		System.out.println("enter city:");
		String city = sc.next();
		System.out.println("enter age");
		int age = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishdb", "root", "");
			Statement stmt = con.createStatement();

			String sql = "UPDATE student SET name = ?, city = ?,age=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(4, id);
			ps.setString(1, name);
			ps.setString(2, city);
			ps.setInt(3, age);
			ps.executeUpdate();
			System.out.println("Updated Succesfully");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
