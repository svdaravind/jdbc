package com.newww;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		boolean b=true;
		while(b) {
		System.out.println("Enter Y/N to insert or not");
		Scanner sc = new Scanner(System.in);
		String c = sc.next().toUpperCase();
		String Yes="Y";
		String No="N";
		if(c.equals(Yes)) {
		System.out.println("enter Student id");
		int id = sc.nextInt();
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

			String sql = "INSERT INTO student VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, city);
			ps.setInt(4, age);
			ps.executeUpdate();
			System.out.println("Inserted in database...");
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		}
		else if(c.equals(No)) {
			System.out.println("exiting...");
			b=false;
		}
		else {
			System.out.println("Enter valid option");
		}
	}

}
}
