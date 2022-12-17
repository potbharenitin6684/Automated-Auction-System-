package com.masai.usecase;

import java.util.Scanner;

import com.masai.bean.Seller;
import com.masai.dao.SellerDAO;
import com.masai.dao.SellerDAOImpl;

public class RegisterSeller {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Seller Id");
		int id = sc.nextInt();
		
		System.out.println("Enter Seller Name");
		String name = sc.next();
		
		System.out.println("Enter Seller Email");
		String email = sc.next();
		
		System.out.println("Enter Seller Password");
		String password = sc.next();
		
		SellerDAO bdao = new SellerDAOImpl();
		
		Seller s = new Seller();
		s.setId(id);
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		
		String result = bdao.registerSeller(s);
		System.out.println(result);
	}
}
