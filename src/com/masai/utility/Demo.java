package com.masai.utility;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {

		Connection conn= DBUtil.provideConnection();
		
		if(conn != null) {
			System.out.println("Connected...");
		}	
	}
}
